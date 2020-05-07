package com.noroesteti.iTrader.api.services;

import java.util.Optional;

import com.noroesteti.iTrader.api.entities.Usuario;


public interface UsuarioService {
	/*
	 * Retora um Usuario pelo Id
	 * @param Id
	 * @return Optional Usuario
	 */
	Optional<Usuario> buscarPorId(Long id);
	
	/*
	 * Retora um Usuario pelo Nome
	 * @param Id
	 * @return Optional Usuario
	 */	
	Optional<Usuario> buscarPorNome(String nome);
	/**
	 * Cadastra um novo usuario na base de dados.
	 * 
	 * @param usuario
	 * @return Usuario
	 */
	Usuario persistir(Usuario usuario);
}

