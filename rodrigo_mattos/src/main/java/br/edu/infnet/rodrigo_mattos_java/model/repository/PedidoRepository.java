package br.edu.infnet.rodrigo_mattos_java.model.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.rodrigo_mattos_java.model.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	List<Pedido> findByDataHoraPedidoBetween(LocalDateTime dataHoraPedidoMinimo, LocalDateTime dataHoraPedidMaximo);
	
	Iterable<Pedido> findAll(Sort by);
}
