package br.edu.infnet.rodrigo_mattos_java.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;
import br.edu.infnet.rodrigo_mattos_java.model.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@Operation(summary = "Recupera todos os Pedidos existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Pedido>> obterLista() {
		return ResponseEntity.ok(pedidoService.obterLista());
	}
	
	@Operation(summary = "Recupera todos os Pedidos existentes ordenados por Valor Total.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista/ordenadaPorValorTotal")
	public ResponseEntity<Collection<Pedido>> obterListaOrdenadaPorValorTotal() {
		return ResponseEntity.ok(pedidoService.obterListaOrdenadaPorValorTotal());
	}
	
	@Operation(summary = "Inclui um novo Pedido.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Pedido cliente) {
		pedidoService.incluir(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MENSAGEM_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um Pedido através do Id.")
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		if (pedidoService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MENSAGEM_EXCLUSAO_SUCESSO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MENSAGEM_PEDIDO_NAO_ENCONTRADO);
	}
	
	@Operation(summary = "Altera um Pedido existente.")
	@PutMapping(value = "/alterar")
	public ResponseEntity<Pedido> alterar(@Valid @RequestBody Pedido pedido) {
		Pedido pedidoAtualizado = pedidoService.alterar(pedido);
		
		return ResponseEntity.ok(pedidoAtualizado);
	}
	
	@Operation(summary = "Recupera pelo Data e Hora do Pedido todos os Pedido existentes.")
	@GetMapping(value = "/filtrarPorDataHoraPedido")
	public ResponseEntity<List<Pedido>> buscarPorPrecoDiariaEntre(@RequestParam LocalDateTime dataHoraPedidoMinimo, @RequestParam LocalDateTime dataHoraPedidoMaximo){
		if (dataHoraPedidoMinimo.isAfter(dataHoraPedidoMaximo)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Pedido> pedidos = pedidoService.buscarPorDataHoraPedidoEntre(dataHoraPedidoMinimo, dataHoraPedidoMaximo);
		
		if(pedidos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pedidos);
		}
		
		return ResponseEntity.ok(pedidos);		
	}
	
	@Operation(summary = "Busca um Pedido através do Id.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> obterbuscarPorIdPorId(@PathVariable Integer id) {
		Pedido pedido = pedidoService.buscarPorId(id);
		
		if (pedido == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(pedido);
	}
}
