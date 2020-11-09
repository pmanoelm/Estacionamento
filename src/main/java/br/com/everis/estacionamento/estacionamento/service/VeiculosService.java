package br.com.everis.estacionamento.estacionamento.service;

import java.util.List;

import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

public interface VeiculosService {

	Veiculos findById(Long Id);

	Veiculos save(VeiculoDTO veiculosdto);

	List<Veiculos> findAll();

	public void deletar(Veiculos veiculo);
}
