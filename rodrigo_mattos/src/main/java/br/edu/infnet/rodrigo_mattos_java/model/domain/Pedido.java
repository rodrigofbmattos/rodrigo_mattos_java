package br.edu.infnet.rodrigo_mattos_java.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime dataHoraPedido;
//	private Date dataHoraRetirada;
//	private Date dataHoraDevolucao;
	private Float valorTotal;
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
//	@JoinColumn(name = "id_veiculo")
//	private List<Veiculo> veiculos;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "id_pedido")
	@JsonManagedReference
	private List<ItemPedido> itensPedido;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente; 
	
//	public Pedido() {
//		veiculos = new ArrayList<Veiculo>();
//	}
	
	public Pedido() {
		itensPedido = new ArrayList<ItemPedido>();
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
//	public Date getDataHoraRetirada() {
//		return dataHoraRetirada;
//	}
//	public void setDataHoraRetirada(Date dataHoraRetirada) {
//		this.dataHoraRetirada = dataHoraRetirada;
//	}
//	public Date getDataHoraDevolucao() {
//		return dataHoraDevolucao;
//	}
//	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
//		this.dataHoraDevolucao = dataHoraDevolucao;
//	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
//	public List<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//	public void setVeiculos(List<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
