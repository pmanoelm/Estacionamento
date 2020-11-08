package br.com.everis.estacionamento.estacionamento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.everis.estacionamento.estacionamento.service.TicketService;

@RunWith(SpringRunner.class)
public class TicketServiceTest {
	@Autowired
	TicketService ticketService;
	@Test
	public void ticketCodigoTeste() {
		int codigo = 125487;
		
		int codigos = ticketService.codigo();
		
			
	}
}
