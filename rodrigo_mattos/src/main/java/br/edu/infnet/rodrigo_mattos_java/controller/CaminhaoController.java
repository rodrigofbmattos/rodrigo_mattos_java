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
import br.edu.infnet.rodrigo_mattos_java.model.domain.Caminhao;
import br.edu.infnet.rodrigo_mattos_java.model.service.CaminhaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/caminhao")
public class CaminhaoController {
	@Autowired
	private CaminhaoService caminhaoService;
	
	@Operation(summary = "Recupera todos os Caminhões existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Caminhao>> obterLista() {
		
		return ResponseEntity.ok(caminhaoService.obterLista());
	}

	@Operation(summary = "Inclui um novo Caminhão.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Caminhao caminhao) {
		
		caminhaoService.incluir(caminhao);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MENSAGEM_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um Caminhão através do Id.")
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {	
		if (caminhaoService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MENSAGEM_EXCLUSAO_SUCESSO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MENSAGEM_VEICULO_NAO_ENCONTRADO);
	}
	
	@Operation(summary = "Altera um Caminhão existente.")
	@PutMapping(value = "/alterar")
	public ResponseEntity<Caminhao> alterar(@RequestBody Caminhao caminhao) {
		
		Caminhao caminhaoAtualizado = caminhaoService.alterar(caminhao);
		
		return ResponseEntity.ok(caminhaoAtualizado);
	}
}
