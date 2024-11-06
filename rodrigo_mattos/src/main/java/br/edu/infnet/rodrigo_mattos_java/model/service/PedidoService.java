package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;
import br.edu.infnet.rodrigo_mattos_java.model.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido incluir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Collection<Pedido> obterLista() {
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
//	public List<Cliente> buscarPorNomeContendo(String nome) {
//		return pedidoRepository.findByNomeContaining(nome);
//	}
	
	public long obterQuantidade() {
		return pedidoRepository.count();
	}

	public Pedido buscarPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
}
