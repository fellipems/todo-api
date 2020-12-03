package io.github.fellipems.todo.rest;

import io.github.fellipems.todo.model.Todo;
import io.github.fellipems.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController         // classe seja um componente do Spring, escaneando e resgistrar como um componente REST. Para que ele receba requisições e envie respostas
@RequestMapping("/api/todos")       // mapemaento de URL para quis serão feitas as requisições desta api
@CrossOrigin("http://localhost:4200")       // colocamos esse Cross pois nosso dominio é diferente do domínio da nossa API. Aqui, configuramos a nossa API para que possa aceitar requisições deste domínio
public class TodoController {

    @Autowired
    private TodoRepository tr;

    @PostMapping
    public Todo save(@RequestBody Todo todo){
        return tr.save(todo);
    }

    @GetMapping
    public List<Todo> getAll(){
        return tr.findAll();
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id){
        return tr.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        tr.deleteById(id);
    }

    @PatchMapping("{id}/done")       // Patch - Atualização parcial em um recurso;
    public Todo markAsDone(@PathVariable Long id){
        return tr.findById(id).map(todo -> {    // findById retorna um Optional, por isso utilizaremos o map. O map pegará o objeto que está dentro do optional(do tipo T0do) e retornaremos um mesmo objeto ou um novo
            todo.setDone(true);
            todo.setDoneDate(LocalDateTime.now());
            tr.save(todo);
            return todo;
        }).orElse(null);
    }

}
