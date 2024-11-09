package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Caminhao;
import br.edu.infnet.rodrigo_mattos_java.model.service.CaminhaoService;

@RestController
public class CaminhaoController {
	@Autowired
	private CaminhaoService caminhaoService;
		
	@GetMapping(value = "/caminhao/lista")
	public Collection<Caminhao> obterLista(){
		
		return caminhaoService.obterLista();
	}

	@PostMapping(value = "/caminhao/incluir")
	public String incluir(@RequestBody Caminhao caminhao) {
		
		caminhaoService.incluir(caminhao);
		
		return "Inclusão realizada com sucesso.";
	}
}
