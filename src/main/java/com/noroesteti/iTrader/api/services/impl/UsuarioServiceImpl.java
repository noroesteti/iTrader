package com.noroesteti.iTrader.api.services.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.noroesteti.iTrader.api.entities.Usuario;
import com.noroesteti.iTrader.api.repositories.UsuarioRepository;
import com.noroesteti.iTrader.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuariorepository;
	


	@Override
	public Optional<Usuario> buscarPorNome(String nome) {
		log.info("Buscando um umsuario por nome: {}", nome);
		return Optional.ofNullable(usuariorepository.findByNome(nome));

	}
	
	@Override
	public Usuario persistir(Usuario usuario) {
		 log.info("Buscando um umsuario por usuario: {}", usuario); 
		return this.usuariorepository.save(usuario);
	}

	@Override
	public Optional<Usuario> buscarPorId(Long id) {
		log.info("Buscando um umsuario por nome: {}", id);
		return ofNullable(usuariorepository.findById(id));

	}

	private Optional<Usuario> ofNullable(Optional<Usuario> findById) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
