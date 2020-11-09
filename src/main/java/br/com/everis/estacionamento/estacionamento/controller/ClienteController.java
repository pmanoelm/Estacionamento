package br.com.everis.estacionamento.estacionamento.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.estacionamento.model.Clientes;
import br.com.everis.estacionamento.estacionamento.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/clientesalvar")
	public String salvar(@RequestBody @Valid Clientes cliente) {
		clienteService.save(cliente);
		return "/clienteSalvar";
	}

	@DeleteMapping("/clienteDeletar")
	public void deletar(@RequestBody Clientes cliente) {
		clienteService.deletar(cliente);
	
	}

	@GetMapping("/clientestodos")
	public Iterable<Clientes> listaClientes( Model model) {
		Iterable<Clientes> clientes = clienteService.findAll();
		model.addAttribute(clientes);
		return clientes;
	}

	@GetMapping("/clienteporid")
	public Clientes clienteById(@PathParam("id") Long id) {
		Clientes cliente = clienteService.findByID(id);
		return cliente;
	}
	
	@PutMapping("/AtualizarCliente")
	public Clientes AtualizarCliente(@RequestBody Clientes cliente) {
		return clienteService.save(cliente);
		
	}
	

}
