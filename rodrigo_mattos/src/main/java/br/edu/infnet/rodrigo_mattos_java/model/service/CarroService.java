package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.exceptions.VeiculoNaoEncontradoException;
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

	public boolean excluir(Integer id) {
		carroRepository.deleteById(id);
		
		return true;
	}
	
	public Carro alterar(Carro carro) {
		if(!carroRepository.existsById(carro.getId())) {
			throw new VeiculoNaoEncontradoException(Constantes.MENSAGEM_VEICULO_NAO_ENCONTRADO);
		}
		
		return carroRepository.save(carro);
	}
	
	public long obterQuantidade() {
		return carroRepository.count();
	}
}
