package br.com.everis.estacionamento.estacionamento.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.estacionamento.model.Ticket;
import br.com.everis.estacionamento.estacionamento.model.Veiculos;
import br.com.everis.estacionamento.estacionamento.repository.TicketRepository;
import br.com.everis.estacionamento.estacionamento.repository.VeiculoRepository;
import br.com.everis.estacionamento.estacionamento.service.TicketService;
import br.com.everis.estacionamento.estacionamento.service.dto.TicketDTO;
import br.com.everis.estacionamento.estacionamento.service.dto.VeiculoDTO;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket findByID(Long id) {

		return ticketRepository.findById(id).get();

	}

	@Override
	public List<Ticket> findAll() {

		return ticketRepository.findAll();
	}

	@Override
	public Double pagamento(double valor) {

		return valor;
	}

	@Override
	public synchronized int codigo() {

		Random gerador = new Random();
		int codigo = gerador.nextInt(1000);
		codigo = codigo * 1658;
		return codigo;

	}

	@Override
	public int vagalivres() {

		Random gerador = new Random();
		int vagasLivres = gerador.nextInt(100);
		return vagasLivres;

	}

	@Override
	public Ticket save(TicketDTO ticketdto) {

		Ticket ticket = new Ticket();
		ticket.setVaga(vagalivres());
		ticket.setCodigoTicket(codigo());
		ticket.setHoraEntrada(LocalDateTime.now());
		ticket.setVeiculo(veiculoRepository.findByPlaca(ticketdto.getPlacaVeiculo()));

		return ticketRepository.save(ticket);

	}

	@Override
	public Ticket AtualizarTicket(Ticket ticket, VeiculoDTO veiculodto) {

		ticket.setHoraSaida(LocalDateTime.now());
		ticket.setValorHora(calculaValor(ticket, veiculodto));
		return ticketRepository.save(ticket);
	}

	public double calculaValor(Ticket ticket, VeiculoDTO veiculodto) {
		double pagar = 0;
		Long difS = ChronoUnit.SECONDS.between(ticket.getHoraEntrada(), ticket.getHoraSaida());
		int hora = (int) (difS / 3600);
		int min = (int) (difS / 60 - hora * 60);
		if (min > 30) {
			pagar = pagar + veiculodto.getValor();
		}
		return pagar = pagar + (veiculodto.getValor() * hora);
	}

}
