package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "caminhao")
public class Caminhao extends Veiculo {
	private Integer idCaminhao;
	private String tipoCaminhao;
	private Float capacidadeCarga;
	
	public Integer getIdCaminhao() {
		return idCaminhao;
	}
	public void setIdCaminhao(Integer idCaminhao) {
		this.idCaminhao = idCaminhao;
	}
	public String getTipoCaminhao() {
		return tipoCaminhao;
	}
	public void setTipoCaminhao(String tipoCaminhao) {
		this.tipoCaminhao = tipoCaminhao;
	}
	public Float getCapacidadeCarga() {
		return capacidadeCarga;
	}
	public void setCapacidadeCarga(Float capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
}
