package br.edu.infnet.rodrigo_mattos_java.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	List<Cliente> findByNomeContaining(String nome, Sort by);
	
	Iterable<Cliente> findAll(Sort by);
}
