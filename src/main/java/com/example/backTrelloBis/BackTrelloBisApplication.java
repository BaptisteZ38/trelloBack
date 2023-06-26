package com.example.backTrelloBis;

import com.example.backTrelloBis.entity.State;
import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.repository.StateRepository;
import com.example.backTrelloBis.repository.TaskRepository;
import com.example.backTrelloBis.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
@EnableSwagger2
public class BackTrelloBisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackTrelloBisApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(final UserRepository userRepository, final TaskRepository taskRepository, final StateRepository stateRepository){
		return args -> {
			List<Task> tasks = new ArrayList<>();

			User user = new User(new ObjectId(), "Zeni", "Baptiste");
			userRepository.insert(user);

			State state1 = new State(new ObjectId(),"A faire");
			State state2 = new State(new ObjectId(),"En cours");
			State state3 = new State(new ObjectId(),"Fait");
			stateRepository.insert(state1);
			stateRepository.insert(state2);
			stateRepository.insert(state3);

			Task task1 = new Task(new ObjectId(),"faire les tests", user.getId(), state1.getId());
			tasks.add(task1);

			Task task2 = new Task(new ObjectId(),"faire maquette", user.getId(), state2.getId());
			tasks.add(task2);

			taskRepository.insert(tasks);
		};
	}*/
}