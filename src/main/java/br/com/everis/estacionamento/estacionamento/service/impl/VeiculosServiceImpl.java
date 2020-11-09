package br.com.everis.estacionamento.estacionamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.model.veiculosEnum;
import br.com.everis.estacionamento.estacionamento.repository.ClienteRepository;
import br.com.everis.estacionamento.estacionamento.repository.VeiculoRepository;
import br.com.everis.estacionamento.estacionamento.service.VeiculosService;
import br.com.everis.estacionamento.estacionamento.service.dto.TicketDTO;
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
	public Veiculos save(VeiculoDTO veiculosDTO) {
		Veiculos veiculo = new Veiculos();

		veiculo.setModelo(veiculosDTO.getModelo());
		veiculo.setPlaca(veiculosDTO.getPlaca());
		veiculo.setTipoVeiculo(veiculosDTO.getTipo().toUpperCase());
		veiculo.setCliente(clienteRepository.findByCpf(veiculosDTO.getCpf()));

		if (veiculosDTO.getTipo().equalsIgnoreCase("carro")) {

			veiculosEnum veiculosenum = veiculosEnum.CARRO;
			int veiculosenumV = veiculosenum.getValue();
			veiculo.setValor(veiculosenumV);
			TicketDTO ticket = new  TicketDTO();
					ticket.setValor(veiculosenumV);
			veiculosDTO.setValor(veiculosenumV);
			return veiculoRepository.save(veiculo);
		}
		if (veiculosDTO.getTipo().equalsIgnoreCase("caminhao")) {
			veiculosEnum veiculosenum = veiculosEnum.CAMINHAO;
			int veiculosenumV = veiculosenum.getValue();
			veiculo.setValor(veiculosenumV);
			veiculosDTO.setValor(veiculosenumV);
			return veiculoRepository.save(veiculo);
		}
		if (veiculosDTO.getTipo().equalsIgnoreCase("moto")) {
			veiculosEnum veiculosenum = veiculosEnum.MOTO;
			int veiculosenumV = veiculosenum.getValue();
			veiculo.setValor(veiculosenumV);
			veiculosDTO.setValor(veiculosenumV);
			return veiculoRepository.save(veiculo);
		}
		return veiculoRepository.save(veiculo);
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
