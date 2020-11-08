package br.com.everis.estacionamento.estacionamento.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_ticket;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	@Column(unique = true)
	private int codigoTicket;
	private int vaga;
	private double valorHora;

	@OneToOne
	@JoinColumn(name = "placa")
	private Veiculos veiculo;

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public Long getId_ticket() {
		return id_ticket;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public void setId_ticket(Long id_ticket) {
		this.id_ticket = id_ticket;
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

	public Long getId() {
		return id_ticket;
	}

	public Ticket() {
		super();
	}

	public int getVagasTotais() {
		return vaga;
	}

	public void setVagasTotais(int vaga) {
		this.vaga = vaga;
	}

	public void setId(Long id) {
		this.id_ticket = id;
	}

	public int getCodigoTicket() {
		return codigoTicket;
	}

	public void setCodigoTicket(int codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public int getVaga() {
		return vaga;
	}

	public void setVaga(int vaga) {
		this.vaga = vaga;
	}

}
