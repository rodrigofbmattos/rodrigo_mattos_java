package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.exceptions.VeiculoNaoEncontradoException;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Veiculo;
import br.edu.infnet.rodrigo_mattos_java.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;	
	
	public void incluir(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
	
	public boolean excluir(Integer id) {
		veiculoRepository.deleteById(id);
		
		return true;
	}
	
	public Veiculo alterar(Veiculo veiculo) {
		if (!veiculoRepository.existsById(veiculo.getId())) {
			throw new VeiculoNaoEncontradoException(Constantes.MENSAGEM_VEICULO_NAO_ENCONTRADO);
		}
		
		return veiculoRepository.save(veiculo);
	}
	
	public Veiculo alterarPrecoDiaria(Integer id, float precoDiaria) {
		Veiculo veiculoExistente = veiculoRepository.findById(id).orElse(null); //TODO: Colocar uma Exception
		
		veiculoExistente.setPrecoDiaria(precoDiaria);
		
		return veiculoRepository.save(veiculoExistente);
	}
	
	public Collection<Veiculo> obterLista() {
		return (Collection<Veiculo>) veiculoRepository.findAll();
	}
	
	public Collection<Veiculo> obterListaOrdenadaPorPrecoDiaria() {
		return (Collection<Veiculo>) veiculoRepository.findAll(Sort.by(Sort.Order.asc("precoDiaria")));
	}
	
	public List<Veiculo> buscarPorPrecoDiariaEntre(float precoDiariaMinimo, float precoDiariaMaximo){
		return veiculoRepository.findByPrecoDiariaBetween(precoDiariaMinimo, precoDiariaMaximo);
	}
	
	public long obterQuantidade() {
		return veiculoRepository.count();
	}

	public Veiculo buscarPorId(Integer id) {
		return veiculoRepository.findById(id).orElse(null);
	}
}
