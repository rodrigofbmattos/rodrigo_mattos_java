package br.edu.infnet.rodrigo_mattos_java.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O Data e Hora do Pedido é obrigatório.")
	//@FutureOrPresent(message = "A Data e Hora do Pedido deve ser igual ou acima da Data Atual")
	private LocalDateTime dataHoraPedido;
	
	@NotNull(message = "O Data e Hora da Retirada do Veículo é obrigatório.")
	//@FutureOrPresent(message = "A Data e Hora da Retirada do Veículo deve ser igual ou acima da Data Atual")
	private LocalDateTime dataHoraRetirada;
	
	@NotNull(message = "O Data e Hora da Devolução do Veículo é obrigatório.")
	//@Future(message = "A Data e Hora da Devolução do Veículo deve ser acima da Data Atual")
	private LocalDateTime dataHoraDevolucao;
	
	@NotNull(message = "O Valor Total do aluguel do Veículo é obrigatório.")
	@Positive(message = "O Valor Total do aluguel do Veículo deve ser maior do que zero.")
	private Float valorTotal;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "id_pedido")
//	@JsonManagedReference
	private List<Veiculo> veiculos;
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
//	@JoinColumn(name = "id_pedido")
//	@JsonManagedReference
//	private List<ItemPedido> itensPedido;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente; 
	
	public Pedido() {
		veiculos = new ArrayList<Veiculo>();
	}
	
//	public Pedido() {
//		itensPedido = new ArrayList<ItemPedido>();
//	}
	
	public Pedido(Integer id) {
		this();
		this.setId(id);
	}
	
	@Override
	public String toString() {
		String dataHoraPedido = null,
				dataHoraRetirada = null,
				dataHoraDevolucao = null;
		
		dataHoraPedido = String.format("%td/%<tm/%<ty %<tH:%<tM:%<tS", this.dataHoraPedido);
		dataHoraRetirada = String.format("%td/%<tm/%<ty %<tH:%<tM:%<tS", this.dataHoraRetirada);
		dataHoraDevolucao = String.format("%td/%<tm/%<ty %<tH:%<tM:%<tS", this.dataHoraDevolucao);
		
		return String.format("%d - Data e Hora do Pedido: %s - Data e Hora da Retirada: %s - Data e Hora da Devolução: %s - R$: %.2f<br>Cliente: %s<br>Veículos: %s<br>", 
				id,
				dataHoraPedido,
				dataHoraRetirada,
				dataHoraDevolucao,
				valorTotal,
				cliente,
				veiculos
			);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataHoraPedido() {
		return dataHoraPedido;
	}
	public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}
	public LocalDateTime getDataHoraRetirada() {
		return dataHoraRetirada;
	}
	public void setDataHoraRetirada(LocalDateTime dataHoraRetirada) {
		this.dataHoraRetirada = dataHoraRetirada;
	}
	public LocalDateTime getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}
	public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
//	public List<ItemPedido> getItensPedido() {
//		return itensPedido;
//	}
//	public void setItensPedido(List<ItemPedido> itensPedido) {
//		this.itensPedido = itensPedido;
//	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
