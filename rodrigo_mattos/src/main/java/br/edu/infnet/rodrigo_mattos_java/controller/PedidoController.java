package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;
import br.edu.infnet.rodrigo_mattos_java.model.service.PedidoService;

@RestController
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/pedido/lista")
	public Collection<Pedido> obterLista() {
		return pedidoService.obterLista();
	}
	
	@PostMapping(value = "/pedido/incluir")
	public String incluir(@RequestBody Pedido cliente) {
		pedidoService.incluir(cliente);
		
		return "Inclusão realizada com sucesso.";
	}
	
	@DeleteMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		pedidoService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
//	@GetMapping(value = "/pedido/buscar/{nome}")
//	public List<Pedido> buscarPorNomeContendo(@PathVariable String nome) {
//		return pedidoService.buscarPorNomeContendo(nome);
//	}
}
