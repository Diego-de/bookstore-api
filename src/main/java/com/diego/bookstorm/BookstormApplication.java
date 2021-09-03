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
public class BookstormApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"informática","Livros de TI");
	
		Livro l1 =  new Livro(null,"Clean code","Robert Martin","Lorem Ipsum",cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
