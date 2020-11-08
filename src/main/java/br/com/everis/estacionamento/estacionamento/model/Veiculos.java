package br.com.everis.estacionamento.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Veiculos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_veiculo;
	private String modelo;
	private String placa;
	private String tipo;
	private int valor;

	@OneToOne
	@JoinColumn(name = "cliente")
	private Clientes cliente;

	public int getValor() {
		return valor;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
