package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
	
	@NotBlank(message = "O CPF do Cliente é obrigatório.")
	@Size(min = 11, max = 11, message = "O CPF do Cliente deve ter 11 caracteres.")
	private String cpf;
	
	@NotBlank(message = "O E-mail do Cliente é obrigatório.")
	@Email(message = "O E-mail do Cliente deve ser um E-mail em formato válido.")
	private String email;
	
//	@Transient	
//	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@Override
	public String toString() {
		return String.format("%d - CPF: %s - Nome: %s<br>Endereço: %s", 
				id,
				cpf,
				nome,
				endereco
			);
	}
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id) {
		this();
		this.setId(id);
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
}
