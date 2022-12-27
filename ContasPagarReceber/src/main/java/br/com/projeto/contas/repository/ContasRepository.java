package br.com.projeto.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.contas.model.Contas;

public interface ContasRepository extends JpaRepository<Contas, Long> {

}
