package br.edu.infnet.rodrigo_mattos_java.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "carro")
public class Carro extends Veiculo {
	private Integer idCarro;
	
	@NotBlank(message = "O Tipo do Carro é obrigatório.")
	@Size(min = 3, max = 50, message = "O Tipo do Carro deve ter entre 3 e 50 caracteres.")
	private String tipoCarro;
	
	@NotBlank(message = "O Tipo Câmbio do Carro é obrigatório.")
	@Size(min = 3, max = 20, message = "O Tipo do Câmbio do Carro deve ter entre 3 e 20 caracteres.")
	private String cambio;
	
	@NotNull(message = "O valor para o Ar Condicionado do Carro é obrigatório.")
	private Boolean arCondicionado;
	
	@Override
	public String toString() {
		return String.format("%d - Quantidade de Passageiros: %d - R$ %.2f - Tipo do Carro: %s - Câmbio: %s - Ar Condicionado: %s",
				super.getId(),
				super.getQuantidadePassageiros(),
				super.getPrecoDiaria(),
				tipoCarro,
				cambio,
				arCondicionado ? "Sim" : "Não"
			);
	}
	
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
