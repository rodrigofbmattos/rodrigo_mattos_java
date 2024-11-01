package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer quantidadePassageiros;
	private Float precoDiaria;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	public Integer getQuantidadePassageiros() {
		return quantidadePassageiros;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantidadePassageirso() {
		return quantidadePassageiros;
	}
	public void setQuantidadePassageiros(Integer quantidadePassageiros) {
		this.quantidadePassageiros = quantidadePassageiros;
	}
	public Float getPrecoDiaria() {
		return precoDiaria;
	}
	public void setPrecoDiaria(Float precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
