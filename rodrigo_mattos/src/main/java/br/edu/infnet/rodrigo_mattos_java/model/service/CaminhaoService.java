package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Caminhao;
import br.edu.infnet.rodrigo_mattos_java.model.repository.CaminhaoRepository;

@Service
public class CaminhaoService {
	@Autowired
	private CaminhaoRepository caminhaoRepository;	

	public Collection<Caminhao> obterLista(){
		return (Collection<Caminhao>) caminhaoRepository.findAll();
	}
	
	public void incluir(Caminhao caminhao) {
		caminhaoRepository.save(caminhao);
	}

	public long obterQuantidade() {
		return caminhaoRepository.count();
	}
}
