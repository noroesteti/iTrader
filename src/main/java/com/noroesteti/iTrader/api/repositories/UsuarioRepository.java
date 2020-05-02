package com.noroesteti.iTrader.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;
import com.noroesteti.iTrader.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
