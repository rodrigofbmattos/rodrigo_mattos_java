package br.edu.infnet.rodrigo_mattos_java.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "veiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "A Quantidade de Passageiros do Veículo é obrigatória.")
	@Positive(message = "A Quantidade de Passageiros do Veículo deve ser maior do que zero.")
	private Integer quantidadePassageiros;
	
	@NotNull(message = "O Preço da Diária do Veículo é obrigatório.")
	//@DecimalMin(value = "0.1", message = "O Preço da Diária do Veículo deve ser maior que zero.")
	@Positive(message = "O Preço da Diária do Veículo deve ser maior do que zero.")
	private Float precoDiaria;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@JsonBackReference
	private Pedido pedido;

	@Override
	public String toString() {
		return String.format("%d - %d - R$ %.2f",
				id,
				quantidadePassageiros,
				precoDiaria/*,
				estoque ? "estoque: sim" : "estoque: não"*/
			);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantidadePassageiros() {
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
