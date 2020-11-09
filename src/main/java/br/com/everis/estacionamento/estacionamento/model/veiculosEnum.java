package br.com.everis.estacionamento.estacionamento.model;

import java.util.HashMap;
import java.util.Map;

public enum veiculosEnum {
	CARRO(10), MOTO(5), CAMINHAO(15);

	private int value;
	private static Map map = new HashMap<>();

	private veiculosEnum(int value) {
        this.value = value;
    }
	static {
        for (veiculosEnum veiculosenum : veiculosEnum.values()) {
            map.put(veiculosenum.value, veiculosenum);
        }
    }

    public static veiculosEnum valueOf(int veiculosenum) {
        return (veiculosEnum) map.get(veiculosenum);
    }

    public int getValue() {
        return value;
    }
}
