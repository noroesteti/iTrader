package com.noroesteti.iTrader.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.noroesteti.iTrader.api.entities.Corretora;


public interface CorretoraRepository extends JpaRepository<Corretora,Long>{
	@Transactional(readOnly=true)
	Corretora findBydsCorretora(String corretora);
	}
