package br.com.everis.estacionamento.estacionamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.Ticket;
import br.com.everis.estacionamento.estacionamento.service.dto.TicketDTO;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

@Service
public interface TicketService {

	Ticket findByID(Long id);

	Ticket save(TicketDTO ticket);

	List<Ticket> findAll();

	Double pagamento(double valor);

	int codigo();

	int vagalivres();

	Ticket AtualizarTicket(Ticket ticket,VeiculoDTO veiculodto);

}
