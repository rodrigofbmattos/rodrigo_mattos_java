package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;
import br.edu.infnet.rodrigo_mattos_java.model.service.ClienteService;

@RestController
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/lista/cliente")
	public Collection<Cliente> obterLista() {
		return clienteService.obterLista();
	}
	
	@GetMapping(value = "/clientes/buscar/{nome}")
	public List<Cliente> buscarPorNomeContendo(@PathVariable String nome) {
		return clienteService.buscarPorNomeContendo(nome);
	}
}
