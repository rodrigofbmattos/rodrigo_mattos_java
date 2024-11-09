package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Carro;
import br.edu.infnet.rodrigo_mattos_java.model.repository.CarroRepository;

@Service
public class CarroService {
	@Autowired
	private CarroRepository carroRepository;	

	public Collection<Carro> obterLista(){
		return (Collection<Carro>) carroRepository.findAll();
	}
	
	public void incluir(Carro carro) {
		carroRepository.save(carro);
	}

	public long obterQuantidade() {
		return carroRepository.count();
	}
}
