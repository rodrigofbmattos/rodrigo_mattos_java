package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
//import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.exceptions.VeiculoNaoEncontradoException;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;
import br.edu.infnet.rodrigo_mattos_java.model.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido incluir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public boolean excluir(Integer id) {
		pedidoRepository.deleteById(id);
		
		return true;
	}
	
	public Pedido alterar(Pedido pedido) {
		if (!pedidoRepository.existsById(pedido.getId())) {
			throw new VeiculoNaoEncontradoException(Constantes.MENSAGEM_PEDIDO_NAO_ENCONTRADO);
		}
		
		return pedidoRepository.save(pedido);
	}
	
	public Collection<Pedido> obterLista() {
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public Collection<Pedido> obterListaOrdenadaPorValorTotal() {
		return (Collection<Pedido>) pedidoRepository.findAll(Sort.by(Sort.Order.asc("valorTotal")));
	}
	
	public List<Pedido> buscarPorDataHoraPedidoEntre(LocalDateTime dataHoraPedidoMinimo, LocalDateTime dataHoraPedidMaximo){
		return pedidoRepository.findByDataHoraPedidoBetween(dataHoraPedidoMinimo, dataHoraPedidMaximo);
	}
	
	public long obterQuantidade() {
		return pedidoRepository.count();
	}

	public Pedido buscarPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
}
