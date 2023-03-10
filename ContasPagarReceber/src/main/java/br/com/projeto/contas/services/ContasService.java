package br.com.projeto.contas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.contas.model.Contas;
import br.com.projeto.contas.repository.ContasRepository;

@Service
@Transactional
public class ContasService {

	@Autowired
	private ContasRepository rep;
	
	public List<Contas> listAll() {
		return rep.findAll();
	}
	
	public List<Contas> listAllByDescricao(String descricao) {
		return rep.findByDescricao(descricao);
	}
	
	public List<Contas> listAllByLikeDescricao(String descricao) {
		return rep.findByDescricaoContaining(descricao);
	}
	
	public List<Contas> listAllFindByValor(float valor) {
		return rep.findByValor(valor);
	}
	
	public void save(Contas conta) {
		rep.save(conta);
	}
	
	public Contas get(Long id) {
		return rep.findById(id).get();
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
