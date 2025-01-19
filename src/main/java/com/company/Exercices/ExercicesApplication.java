package com.company.Exercices;

import com.company.Exercices.config.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicesApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExercicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("admin", "admin", "admin"));
	}
}


