package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import jakarta.persistence.Transient;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O Nome do Cliente é obrigatório.")
	@Size(min = 3, max = 50, message = "O Nome do Cliente deve ter entre 3 e 50 caracteres.")
	private String nome;
	
	private String cpf;
	private String email;
	
//	@Transient	
//	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

//	@Transient
//	private Pedido pedido;

//	@Override
//	public String toString() {
//		return String.format("[%s] - [%d]: Cliente %s cadastrado com sucesso! %s; Produtos: %d", 
//				cpf,
//				id,
//				nome,
//				endereco,
//				produtos.size()
//			);
//	}
	
	@Override
	public String toString() {
		return String.format("[%s] - [%d]: Cliente %s cadastrado com sucesso! Endereço: %s", 
				cpf,
				id,
				nome,
				endereco
			);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
//	public Pedido getPedido() {
//		return pedido;
//	}
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
}
