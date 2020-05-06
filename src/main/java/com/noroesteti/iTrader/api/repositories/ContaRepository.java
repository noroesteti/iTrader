package com.noroesteti.iTrader.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.noroesteti.iTrader.api.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{
	@Transactional(readOnly=true)
	Conta findBycdConta(Long conta);
}
