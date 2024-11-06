package br.edu.infnet.rodrigo_mattos_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Caminhao;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Carro;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Endereco;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Estado;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Municipio;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;
import br.edu.infnet.rodrigo_mattos_java.model.service.ClienteService;
import br.edu.infnet.rodrigo_mattos_java.model.service.LocalizacaoService;
import br.edu.infnet.rodrigo_mattos_java.model.service.PedidoService;
import br.edu.infnet.rodrigo_mattos_java.model.service.VeiculoService;

@Component
public class Loader implements ApplicationRunner {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private LocalizacaoService localizacaoService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private PedidoService pedidoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (Estado estado : localizacaoService.obterEstados()) {
			System.out.println("Estado: " + estado.getNome());
		}
		
		for (Municipio municipio : localizacaoService.obterMunicipios(33)) {
			System.out.println("Município: " + municipio.getNome());
		}
		
		FileReader file = new FileReader("files/aluguel_veiculos.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		
		Cliente cliente = null;

		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "C":
				
				cliente = new Cliente();
				cliente.setNome(campos[2]);
				cliente.setCpf(campos[3]);
				cliente.setEmail(campos[4]);
				
				cliente.setEndereco(new Endereco(campos[5]));
								
				cliente = clienteService.incluir(cliente);
				
				System.out.println("Cliente: [" + cliente + "]");
				
				break;

			case "CR":
				Carro carro = new Carro();
				
				carro.setIdCarro(Integer.valueOf(campos[1]));
				carro.setQuantidadePassageiros(Integer.valueOf(campos[2]));
				carro.setPrecoDiaria(Float.valueOf(campos[3]));
				carro.setTipoCarro(campos[4]);
				carro.setCambio(campos[5]);
				carro.setArCondicionado(Boolean.valueOf(campos[6]));
				
				veiculoService.incluir(carro);
				
				break;

			case "CM":
				Caminhao caminhao = new Caminhao();
				
				caminhao.setIdCaminhao(Integer.valueOf(campos[1]));
				caminhao.setQuantidadePassageiros(Integer.valueOf(campos[2]));
				caminhao.setPrecoDiaria(Float.valueOf(campos[3]));
				caminhao.setTipoCaminhao(campos[4]);
				caminhao.setCapacidadeCarga(Float.valueOf(campos[5]));
				
				veiculoService.incluir(caminhao);
				
				break;
				
			case "P":
				Pedido pedido = new Pedido();
				
				pedido.setId(Integer.valueOf(campos[1]));
				pedido.setDataHoraPedido(LocalDateTime.parse(campos[2]));
				pedido.setValorTotal(Float.valueOf(campos[3]));
				
//				cliente = clienteService.buscarPorId(Integer.valueOf(campos[4]));
//				
//				pedido.setCliente(cliente);
//				
//				pedidoService.incluir(pedido);
				
				break;

			default:
				break;
			}
					
			linha = leitura.readLine();
		}
		
		for (Cliente c: clienteService.obterLista()) {
			System.out.println("Cliente cadastrado com sucesso: " + c);	
		}

		leitura.close();		
	}

}
