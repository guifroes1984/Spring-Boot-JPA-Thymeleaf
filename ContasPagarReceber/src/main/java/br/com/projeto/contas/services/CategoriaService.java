package br.com.projeto.contas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.contas.model.Categoria;
import br.com.projeto.contas.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	public List<Categoria> listAll() {
		return rep.findAll();
	}

}
