package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Veiculo;
import br.edu.infnet.rodrigo_mattos_java.model.service.VeiculoService;

@RestController
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping(value = "/lista/veiculo")
	public Collection<Veiculo> obterLista() {
		return veiculoService.obterLista();
	}
	
	@GetMapping(value = "/veiculos/filtrarPorPrecoDiaria/{precoDiariaMinimo}/{precoDiariaMaximo}")
	public List<Veiculo> obterListaPorPrecoDiariaEntre(@PathVariable float precoDiariaMinimo, @PathVariable float precoDiariaMaximo){
		return veiculoService.buscarPorPrecoDiariaEntre(precoDiariaMinimo, precoDiariaMaximo);
	}
}
