package br.com.everis.estacionamento.estacionamento.model;

public enum TipoVeiculos {
	CARROS(10), MOTO(5), CAMINHAO(15),
	carros(10), moto(5), caminhao(15),
	carro(10), motos(5), caminhaos(15);

	private int valor;

	private TipoVeiculos(int valor) {
		this.valor = valor;
		;
	}

	public int getValor() {
		return valor;
	}

}
