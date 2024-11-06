package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Veiculo;
import br.edu.infnet.rodrigo_mattos_java.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;	
	
	public void incluir(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
	
	public void excluir(Integer id) {
		veiculoRepository.deleteById(id);
	}
	
	public Collection<Veiculo> obterLista() {
		return (Collection<Veiculo>) veiculoRepository.findAll();
	}
	
	public List<Veiculo> buscarPorPrecoDiariaEntre(float precoDiariaMinimo, float precoDiariaMaximo){
		return veiculoRepository.findByPrecoDiariaBetween(precoDiariaMinimo, precoDiariaMaximo);
	}
	
	public long obterQuantidade() {
		return veiculoRepository.count();
	}
}
