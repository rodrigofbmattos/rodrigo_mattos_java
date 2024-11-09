package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/veiculo/filtrarPorPrecoDiaria")
	public ResponseEntity<List<Veiculo>> obterListaPorPrecoDiariaEntre(@RequestParam float precoDiariaMinimo, @RequestParam float precoDiariaMaximo){
		if (precoDiariaMinimo < 0 || precoDiariaMaximo < 0 || precoDiariaMinimo > precoDiariaMaximo) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Veiculo> veiculos = veiculoService.buscarPorPrecoDiariaEntre(precoDiariaMinimo, precoDiariaMaximo);
		
		if(veiculos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veiculos);
		}
		
		return ResponseEntity.ok(veiculos);		
	}
	
	@GetMapping(value = "/veiculo/{id}")
	public Veiculo obterPorId(@PathVariable Integer id) {
		return veiculoService.obterPorId(id);
	}
}
