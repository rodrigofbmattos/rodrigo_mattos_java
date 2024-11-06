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

import br.edu.infnet.rodrigo_mattos_java.model.domain.Veiculo;
import br.edu.infnet.rodrigo_mattos_java.model.service.VeiculoService;

@RestController
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping(value = "/veiculo/lista")
	public Collection<Veiculo> obterLista() {
		return veiculoService.obterLista();
	}
	
	@PostMapping(value = "/veiculo/incluir")
	public String incluir(@RequestBody Veiculo veiculo) {
		veiculoService.incluir(veiculo);
		
		return "Inclusão realizada com sucesso.";
	}
	
	@DeleteMapping(value = "/veiculo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {	
		veiculoService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@GetMapping(value = "/veiculo/filtrarPorPrecoDiaria/{precoDiariaMinimo}/{precoDiariaMaximo}")
	public List<Veiculo> obterListaPorPrecoDiariaEntre(@PathVariable float precoDiariaMinimo, @PathVariable float precoDiariaMaximo){
		return veiculoService.buscarPorPrecoDiariaEntre(precoDiariaMinimo, precoDiariaMaximo);
	}
}
