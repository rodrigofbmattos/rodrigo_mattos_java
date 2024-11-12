package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Veiculo;
import br.edu.infnet.rodrigo_mattos_java.model.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;
	
	@Operation(summary = "Recupera todos os Veículos existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Veiculo>> obterLista() {
		return ResponseEntity.ok(veiculoService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo Veículo.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Veiculo veiculo) {
		veiculoService.incluir(veiculo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MENSAGEM_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um Veículo através do Id.")
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {	
		if (veiculoService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MENSAGEM_EXCLUSAO_SUCESSO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MENSAGEM_CLIENTE_NAO_ENCONTRADO);
	}
	
	@Operation(summary = "Altera um Veículo existente.")
	@PutMapping(value = "/alterar")
	public ResponseEntity<Veiculo> alterar(@Valid @RequestBody Veiculo veiculo) {
		Veiculo veiculoAtualizado = veiculoService.alterar(veiculo);
		
		return ResponseEntity.ok(veiculoAtualizado);
	}
	
	@Operation(summary = "Altera o Preco da Diário de um Veículo existente.")
	@PatchMapping(value = "/alterarPrecoDiaria")
	public ResponseEntity<Veiculo> alterarPrecoDiaria(@Valid @RequestParam Integer id, @RequestParam float precoDiaria) {
		Veiculo veiculoAtualizado = veiculoService.alterarPrecoDiaria(id, precoDiaria);
		
		return ResponseEntity.ok(veiculoAtualizado);
	}
	
	@Operation(summary = "Recupera pelo Preço da Diária todos os Veículos existentes.")
	@GetMapping(value = "/filtrarPorPrecoDiaria")
	public ResponseEntity<List<Veiculo>> buscarPorPrecoDiariaEntre(@RequestParam float precoDiariaMinimo, @RequestParam float precoDiariaMaximo){
		if (precoDiariaMinimo < 0 || precoDiariaMaximo < 0 || precoDiariaMinimo > precoDiariaMaximo) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Veiculo> veiculos = veiculoService.buscarPorPrecoDiariaEntre(precoDiariaMinimo, precoDiariaMaximo);
		
		if(veiculos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veiculos);
		}
		
		return ResponseEntity.ok(veiculos);		
	}
	
	@Operation(summary = "Busca um Veículo através do Id.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> obterbuscarPorIdPorId(@PathVariable Integer id) {
		Veiculo veiculo = veiculoService.buscarPorId(id);
		
		if (veiculo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(veiculo);
	}
}
