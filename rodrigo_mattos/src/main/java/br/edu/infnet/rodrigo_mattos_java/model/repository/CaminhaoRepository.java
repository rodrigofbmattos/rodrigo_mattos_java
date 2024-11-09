package br.edu.infnet.rodrigo_mattos_java.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Caminhao;

@Repository
public interface CaminhaoRepository extends CrudRepository<Caminhao, Integer> {

}
