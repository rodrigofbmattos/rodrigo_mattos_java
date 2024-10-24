package br.edu.infnet.rodrigo_mattos_java.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoClient {

	@GetMapping(value = "/{cep}/json/")
	Endereco buscarPorCep(@PathVariable String cep);
}