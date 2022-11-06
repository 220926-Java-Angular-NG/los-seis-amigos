package com.losAmigos.magiczon;

import com.losAmigos.magiczon.repos.card.CardRepo;
import com.losAmigos.magiczon.repos.card.CardRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MagiczonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagiczonApplication.class, args);
	}

}
