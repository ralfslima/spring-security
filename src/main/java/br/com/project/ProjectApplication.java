package br.com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		System.out.println("ADMINISTRADOR -> " + new BCryptPasswordEncoder().encode("123"));
		System.out.println("USUÁRIO -> " + new BCryptPasswordEncoder().encode("abc"));
	}

}
