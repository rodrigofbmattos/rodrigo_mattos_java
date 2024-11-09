package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Carro;
import br.edu.infnet.rodrigo_mattos_java.model.service.CarroService;

@RestController
public class CarroController {
	@Autowired
	private CarroService carroService;
		
	@GetMapping(value = "/carro/lista")
	public Collection<Carro> obterLista(){
		
		return carroService.obterLista();
	}

	@PostMapping(value = "/carro/incluir")
	public String incluir(@RequestBody Carro carro) {
		
		carroService.incluir(carro);
		
		return "Inclusão realizada com sucesso.";
	}
}
