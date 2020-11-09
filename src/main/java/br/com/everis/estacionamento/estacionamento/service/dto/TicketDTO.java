package br.com.everis.estacionamento.estacionamento.service.dto;

import java.time.LocalDateTime;

public class TicketDTO {

	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private String codigoTicket;
	private String vaga;
	private String placaVeiculo;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getCodigoTicket() {
		return codigoTicket;
	}

	public void setCodigoTicket(String codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}



	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

}