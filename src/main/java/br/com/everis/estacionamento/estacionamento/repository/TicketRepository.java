package br.com.everis.estacionamento.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.estacionamento.estacionamento.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
