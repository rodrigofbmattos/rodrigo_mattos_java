package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;
import br.edu.infnet.rodrigo_mattos_java.model.service.ClienteService;

@RestController
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/cliente/lista")
	public Collection<Cliente> obterLista() {
		return clienteService.obterLista();
	}
	
	@PostMapping(value = "/cliente/incluir")
	public String incluir(@RequestBody Cliente cliente) {
		clienteService.incluir(cliente);
		
		return "Inclusão realizada com sucesso.";
	}
	
	@DeleteMapping(value = "/cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@GetMapping(value = "/cliente/buscar/{nome}")
	public List<Cliente> buscarPorNomeContendo(@PathVariable String nome) {
		return clienteService.buscarPorNomeContendo(nome);
	}
}
