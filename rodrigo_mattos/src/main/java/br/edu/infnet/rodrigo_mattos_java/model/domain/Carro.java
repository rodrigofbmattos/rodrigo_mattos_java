package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro extends Veiculo {
	private Integer idCarro;
	private String tipoCarro;
	private String cambio;
	private Boolean arCondicionado;
	
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public String getTipoCarro() {
		return tipoCarro;
	}
	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public Boolean getArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
}
