package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.ItemPedido;
import br.edu.infnet.rodrigo_mattos_java.model.service.ItemPedidoService;

@RestController
public class ItemPedidoController {
	@Autowired
	private ItemPedidoService itemPedidoService;
		
	@GetMapping(value = "/itemPedido/lista")
	public Collection<ItemPedido> obterLista(){
		
		return itemPedidoService.obterLista();
	}

	@PostMapping(value = "/itemPedido/incluir")
	public String incluir(@RequestBody ItemPedido itemPedido) {
		
		itemPedidoService.incluir(itemPedido);
		
		return "Inclusão realizada com sucesso.";
	}
}
