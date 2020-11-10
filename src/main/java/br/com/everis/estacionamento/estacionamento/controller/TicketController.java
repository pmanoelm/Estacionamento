package br.com.everis.estacionamento.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.estacionamento.model.Ticket;
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

	@PutMapping("/AtualizarTicket/{id}")
	public Ticket AtualizarTicket(@PathVariable Long id) {
		Ticket ticket = ticketservice.findByID(id);
		return ticketservice.AtualizarTicket(ticket);

	}
	@PutMapping("/AtualizarTicket")
	public Ticket AtualizarTicket(@RequestBody Ticket ticket) {

		return ticketservice.AtualizarTicket(ticket);

	}

	@GetMapping("/ticketodos")
	public Iterable<Ticket> listaTickets(Model model) {
		Iterable<Ticket> ticket = ticketservice.findAll();
		model.addAttribute(ticket);
		return ticket;
	}
}
