package br.edu.infnet.rodrigo_mattos_java.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Carro;
import br.edu.infnet.rodrigo_mattos_java.model.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	private CarroService carroService;
		
	@Operation(summary = "Recupera todos os Carros existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Carro>> obterLista(){
		
		return ResponseEntity.ok(carroService.obterLista());
	}

	@Operation(summary = "Inclui um novo Carro.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Carro carro) {
		
		carroService.incluir(carro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MENSAGEM_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um Carro através do Id.")
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {	
		if (carroService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MENSAGEM_EXCLUSAO_SUCESSO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MENSAGEM_VEICULO_NAO_ENCONTRADO);
	}
	
	@Operation(summary = "Altera um Carro existente.")
	@PutMapping(value = "/alterar")
	public ResponseEntity<Carro> alterar(@RequestBody Carro carro) {
		
		Carro carroAtualizado = carroService.alterar(carro);
		
		return ResponseEntity.ok(carroAtualizado);
	}
}
