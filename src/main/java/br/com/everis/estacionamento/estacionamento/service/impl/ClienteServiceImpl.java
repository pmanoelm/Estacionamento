package br.com.everis.estacionamento.estacionamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.Clientes;
import br.com.everis.estacionamento.estacionamento.repository.ClienteRepository;
import br.com.everis.estacionamento.estacionamento.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Clientes findByID(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public Clientes save(Clientes clientes) {
		return clienteRepository.save(clientes);
	}

	@Override
	public List<Clientes> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public void deletar(Clientes Cliente) {
		clienteRepository.delete(Cliente);
		
	}
	

	@Override
	public Clientes AtualizarCliente(Clientes cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
