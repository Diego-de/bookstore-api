package com.diego.bookstorm.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.bookstorm.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer>{

}
