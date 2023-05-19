package ru.vsu.cs.zmaev.bankservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.vsu.cs.zmaev.bankservice.models.Client;
import ru.vsu.cs.zmaev.bankservice.repositories.ClientRepository;

@SpringBootApplication
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository) {
		clientRepository.save(new Client("Ben", "Smith"));
	}
}
