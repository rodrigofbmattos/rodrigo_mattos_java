package br.edu.infnet.rodrigo_mattos_java.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigo_mattos_java.client.EnderecoClient;
import br.edu.infnet.rodrigo_mattos_java.client.LocalidadeClient;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Endereco;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Estado;
import br.edu.infnet.rodrigo_mattos_java.model.domain.Municipio;

@Service
public class LocalizacaoService {
	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco buscarPorCep(String cep) {
		return enderecoClient.buscarPorCep(cep);
	}
	
	public Collection<Estado> obterEstados() {
		return localidadeClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer uf) {
		return localidadeClient.obterMunicipios(uf);
	}
}
