package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Endereco;
import br.edu.infnet.rodrigo_mattos_java.model.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LocalizacaoService localizacaoService;

	public Cliente incluir(Cliente cliente) {
		
		String cep = cliente.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.buscarPorCep(cep);

		cliente.setEndereco(endereco);

		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> obterLista() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public List<Cliente> buscarPorNomeContendo(String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}
}
