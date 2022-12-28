package br.com.projeto.contas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.contas.model.Contas;

public interface ContasRepository extends JpaRepository<Contas, Long> {
	
	List<Contas> findByDescricao(String descricao);
	
	List<Contas> findByDescricaoContaining(String descricao);
	
	List<Contas> findByValor(float valor);

}
