package br.com.everis.estacionamento.estacionamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.Clientes;

@Service
public interface ClienteService {

	Clientes findByID(Long id);

	Clientes save(Clientes clientes);

	List<Clientes> findAll();

	void deletar(Clientes cliente);

	Clientes AtualizarCliente(Clientes cliente);
}
