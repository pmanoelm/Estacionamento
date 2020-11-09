package br.com.everis.estacionamento.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.estacionamento.model.Ticket;
import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.service.TicketService;
import br.com.everis.estacionamento.estacionamento.service.dto.TicketDTO;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketservice;


	@PostMapping("ticketsalvar")
	public String ticketsalvar(@RequestBody TicketDTO ticketdto) {

		ticketservice.save(ticketdto);
		return "/ticketsalvar";
	}

	@PutMapping("/AtualizarTicket")
	public Ticket AtualizarTicket(@RequestBody Ticket ticket, VeiculoDTO veiculoDto) {

		return ticketservice.AtualizarTicket(ticket, veiculoDto);

	}

	@GetMapping("/ticketodos")
	public Iterable<Ticket> listaTickets(Model model) {
		Iterable<Ticket> ticket = ticketservice.findAll();
		model.addAttribute(ticket);
		return ticket;
	}
}
