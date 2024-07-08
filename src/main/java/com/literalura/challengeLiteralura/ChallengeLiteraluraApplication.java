package com.literalura.challengeLiteralura;

import com.literalura.challengeLiteralura.methods.AuthorSearch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraApplication
		implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// I'm going to initialize the App here
		AuthorSearch authorSearch = new AuthorSearch();
		authorSearch.showMenu();



	}
}
