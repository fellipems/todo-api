package io.github.fellipems.todo;

import io.github.fellipems.todo.model.Todo;
import io.github.fellipems.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TodoApplication {

//	@Autowired
//	private TodoRepository tr;

//	@Bean
//	public CommandLineRunner init(){		// realiza algum código ao inicializar o contexto da aplicação
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				To do to do = new To do();
//				to do.setDescription("Estudar Java");
//				to do.setCreatedDate(LocalDateTime.now());
//				tr.save(to do);
//			}
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
