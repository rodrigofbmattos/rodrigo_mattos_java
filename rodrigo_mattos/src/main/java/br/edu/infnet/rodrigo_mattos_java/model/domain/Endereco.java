package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O CEP do Cliente é obrigatório.")
	@Size(min = 8, max = 9, message = "O CEP do Cliente deve ter 8 caracteres. 9 caracteres se houver traço.")
	private String cep;
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	
	public Endereco() {
		
	}
	
	public Endereco(String cep) {
		this();
		this.setCep(cep);
	}
	
	@Override
	public String toString() {
		return String.format("CEP: %s - Logradouro: %s; Complemento: %s; Bairro: %s; Localidade: %s; UF: %s",
				cep,
				logradouro,
				(complemento == "" ? "N/A" : complemento),
				bairro,
				localidade,
				uf);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
