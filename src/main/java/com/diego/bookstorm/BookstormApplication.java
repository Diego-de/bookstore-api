package com.diego.bookstorm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diego.bookstorm.domain.Categoria;
import com.diego.bookstorm.domain.Livro;
import com.diego.bookstorm.repositores.CategoriaRepository;
import com.diego.bookstorm.repositores.LivroRepository;

@SpringBootApplication
public class BookstormApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstormApplication.class, args);
	}

}
