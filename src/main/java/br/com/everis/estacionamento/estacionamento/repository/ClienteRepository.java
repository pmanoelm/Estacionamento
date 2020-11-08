package br.com.everis.estacionamento.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.estacionamento.estacionamento.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

	Clientes findByCpf(String cpf);

	List<Clientes> findByNome(String nome);

}
