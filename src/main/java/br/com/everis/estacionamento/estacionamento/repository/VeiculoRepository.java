package br.com.everis.estacionamento.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.estacionamento.estacionamento.model.Veiculos;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculos, Long> {

	Veiculos findByPlaca(String placa);

	Veiculos findByValor(int valor);

}
