package br.edu.infnet.rodrigo_mattos_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.rodrigo_mattos_java.model.service.ClienteService;
import br.edu.infnet.rodrigo_mattos_java.model.service.PedidoService;
import br.edu.infnet.rodrigo_mattos_java.model.service.VeiculoService;

@Controller
public class AppController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ClienteService carroService;
	@Autowired
	private ClienteService caminhaoService;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model) {
		model.addAttribute("quantidadeCliente", clienteService.obterQuantidade());
		model.addAttribute("quantidadeVeiculo", veiculoService.obterQuantidade());
		model.addAttribute("quantidadeCarro", carroService.obterQuantidade());
		model.addAttribute("quantidadeCaminhao", caminhaoService.obterQuantidade());
		model.addAttribute("quantidadePedido", pedidoService.obterQuantidade());

		return "home";
	}
	
	@GetMapping(value = "/cliente/listagem")
	public String clienteLista(Model model) {	
		model.addAttribute("titulo", "Listagem de Clientes");
		model.addAttribute("listagem", clienteService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/veiculo/listagem")
	public String veiculoLista(Model model) {
		model.addAttribute("titulo", "Listagem de Veículos");
		model.addAttribute("listagem", veiculoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/carro/listagem")
	public String carroLista(Model model) {
		model.addAttribute("titulo", "Listagem de Carros");
		model.addAttribute("listagem", veiculoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/caminhao/listagem")
	public String caminhaoLista(Model model) {
		model.addAttribute("titulo", "Listagem de Caminhões");
		model.addAttribute("listagem", veiculoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/pedido/listagem")
	public String pedidoLista(Model model) {
		model.addAttribute("titulo", "Listagem de Pedidos");
		model.addAttribute("listagem", pedidoService.obterLista());
		
		return telaHome(model);
	}
}
