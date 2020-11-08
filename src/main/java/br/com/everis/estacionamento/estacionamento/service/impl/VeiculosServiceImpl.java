package br.com.everis.estacionamento.estacionamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.TipoVeiculos;
import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.repository.ClienteRepository;
import br.com.everis.estacionamento.estacionamento.repository.VeiculoRepository;
import br.com.everis.estacionamento.estacionamento.service.VeiculosService;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

@Service
public class VeiculosServiceImpl implements VeiculosService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public String findByPlaca(String placa) {
		return veiculoRepository.findByPlaca(placa).toString();
	}

	@Override
	public Veiculos save(VeiculoDTO veiculosdto, TipoVeiculos tipo) {

		Veiculos veiculos = new Veiculos();
		veiculos.setModelo(veiculosdto.getModelo());
		veiculos.setPlaca(veiculosdto.getPlaca());
		veiculos.setTipo(veiculosdto.getTipo());
		veiculos.setCliente(clienteRepository.findByCpf(veiculosdto.getCpf()));

		if (tipo.toString() != veiculosdto.getTipo()) {

			veiculos.setValor(tipo.getValor());
			return veiculoRepository.save(veiculos);

		}
		return veiculoRepository.save(veiculos);

	}

	@Override
	public List<Veiculos> findAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public void deletar(Veiculos veiculos) {
		veiculoRepository.delete(veiculos);
	}

}
