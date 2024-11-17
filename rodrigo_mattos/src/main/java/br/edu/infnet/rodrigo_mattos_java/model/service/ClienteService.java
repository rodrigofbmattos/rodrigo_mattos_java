package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.Constantes;
import br.edu.infnet.rodrigo_mattos_java.exceptions.ClienteNaoEncontradoException;
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
	
	public boolean excluir(Integer id) {
		clienteRepository.deleteById(id);
		
		return true;
	}
	
	public Cliente alterar(Cliente cliente) {
		if (!clienteRepository.existsById(cliente.getId())) {
			throw new ClienteNaoEncontradoException(Constantes.MENSAGEM_CLIENTE_NAO_ENCONTRADO);
		}
		
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> obterLista() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterListaOrdenadaPorNome() {
		return (Collection<Cliente>) clienteRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public List<Cliente> buscarPorNomeContendo(String nome) {
		return clienteRepository.findByNomeContaining(nome, null);
	}
	
	public List<Cliente> buscarPorNomeContendoOrdenadoPorNome(String nome) {
		return clienteRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public long obterQuantidade() {
		return clienteRepository.count();
	}

	public Cliente buscarPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
}
