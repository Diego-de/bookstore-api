package com.diego.bookstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.bookstorm.domain.Categoria;
import com.diego.bookstorm.dtos.CategoriaDTO;
import com.diego.bookstorm.repositores.CategoriaRepository;
import com.diego.bookstorm.service.exceptions.DataIntegrityViolationException;
import com.diego.bookstorm.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id){
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: " + id + " Tipo: "+ Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescriçao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.diego.bookstorm.service.exceptions.DataIntegrityViolationException(
					"Categoria não pode ser deletado! possui livros associados");
		}
		
	}
}
