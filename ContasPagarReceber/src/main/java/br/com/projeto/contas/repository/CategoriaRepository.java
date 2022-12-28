package br.com.projeto.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.contas.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
}

