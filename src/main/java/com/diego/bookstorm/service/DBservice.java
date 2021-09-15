package com.diego.bookstorm.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.bookstorm.domain.Categoria;
import com.diego.bookstorm.domain.Livro;
import com.diego.bookstorm.repositores.CategoriaRepository;
import com.diego.bookstorm.repositores.LivroRepository;

@Service
public class DBservice {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria cat1 = new Categoria(null, "informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção cientifica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografia");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "The time Machine", "H.G Wells", "Lorem Ipsum", cat2);
		Livro l4 = new Livro(null, "The War Of Worlds", "H.G Wells", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem Ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
