package br.com.everis.estacionamento.estacionamento.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.service.VeiculosService;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

@RestController
public class VeiculoController {

	@Autowired
	private VeiculosService veiculoService;

	@PostMapping("/veiculosalvar")
	public String salvar(@RequestBody @Valid VeiculoDTO veiculosdto) {
		veiculoService.save(veiculosdto);
		return "/clienteSalvar";
	}

	@DeleteMapping("/veiculodeletar")
	public void deletar(@RequestBody Veiculos veiculos) {
		veiculoService.deletar(veiculos);

	}

	@GetMapping("/veiculotodos")
	public Iterable<Veiculos> listaVeiculos(Model model) {
		Iterable<Veiculos> veiculos = veiculoService.findAll();
		model.addAttribute(veiculos);
		return veiculos;
	}

	@GetMapping("/veiculoporporid")
	public Veiculos VeiculoByPlaca(@PathParam("id") Long id) {
		Veiculos veiculo = veiculoService.findById(id);
		return veiculo;
	}
	
	
}
