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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;
import br.edu.infnet.rodrigo_mattos_java.model.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	private static final String MENSAGEM_INCLUSAO_SUCESSO = "Inclusão realizada com sucesso.";
	private static final String MENSAGEM_EXCLUSAO_SUCESSO = "Exclusão realizada com sucesso.";
	private static final String MENSAGEM_EXCLUSAO_NAO_ENCONTRADO = "Cliente não encontrado.";
	
	@Operation(summary = "Recupera todos os Clientes existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Cliente>> obterLista() {
		return ResponseEntity.ok(clienteService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo Cliente.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Cliente cliente) {
		clienteService.incluir(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(MENSAGEM_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um Cliente através do Id.")
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		if (clienteService.excluir(id)) {
			return ResponseEntity.ok(MENSAGEM_EXCLUSAO_SUCESSO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MENSAGEM_EXCLUSAO_NAO_ENCONTRADO);
	}
	
	@Operation(summary = "Busca um Cliente através do Nome.")
	@GetMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Cliente>> buscarPorNomeContendo(@PathVariable String nome) {
		List<Cliente> clientes = clienteService.buscarPorNomeContendo(nome);
		
		if (clientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clientes);
		}
		
		return ResponseEntity.ok(clientes);
	}
	
	@Operation(summary = "Busca um Cliente através do Id.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
		
		Cliente cliente = clienteService.buscarPorId(id);
		
		if(cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(cliente);
	}
}
