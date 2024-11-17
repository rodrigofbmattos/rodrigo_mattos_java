package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "caminhao")
public class Caminhao extends Veiculo {
	private Integer idCaminhao;
	
	@NotBlank(message = "O Tipo do Caminhão é obrigatório.")
	@Size(min = 3, max = 50, message = "O Tipo do Caminhão deve ter entre 3 e 50 caracteres.")
	private String tipoCaminhao;
	
	@NotNull(message = "A Capacidade de Carga do Caminhão é obrigatório.")
	@Positive(message = "A Capacidade de Carga do Caminhão deve ser maior do que zero.")
	private Float capacidadeCarga;
	
	@Override
	public String toString() {
		return String.format("%d - Quantidade de Passageiros: %d - R$ %.2f - Tipo do Caminhão: %s - Kg: %s",
				super.getId(),
				super.getQuantidadePassageiros(),
				super.getPrecoDiaria(),
				tipoCaminhao,
				capacidadeCarga
			);
	}
	
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
