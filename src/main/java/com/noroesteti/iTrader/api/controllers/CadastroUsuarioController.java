package com.noroesteti.iTrader.api.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noroesteti.iTrader.api.dtos.CadastroUsuarioDto;
import com.noroesteti.iTrader.api.entities.Usuario;
import com.noroesteti.iTrader.api.response.Response;
import com.noroesteti.iTrader.api.services.UsuarioService;

@RestController
@RequestMapping("/api/cadastro/usuario/")
@CrossOrigin(origins = "*")
public class CadastroUsuarioController {
	private static final Logger log = LoggerFactory.getLogger(CadastroUsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public ResponseEntity<Response<CadastroUsuarioDto>> cadastrar(@Valid @RequestBody CadastroUsuarioDto cadastroUsuarioDto,
				BindingResult result) throws NoSuchAlgorithmException{
		log.info("Cadastrando Usuario: {}", cadastroUsuarioDto.toString());
		Response<CadastroUsuarioDto> response = new Response<CadastroUsuarioDto>();
		
		validarDatosExistentes(cadastroUsuarioDto,result);
		Usuario usuario = this.converterDtoParaUsuario(cadastroUsuarioDto,result);
		
		if(result.hasErrors()) {
			log.error("Erro validando dados do Cadastro de Usuario: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.usuarioService.persistir(usuario);
		
		response.setData(this.converterCadastroUsuarioDto(usuario, result));
		
	}


	private CadastroUsuarioDto converterCadastroUsuarioDto(Usuario usuario, BindingResult result) {
		
	}


	private Usuario converterDtoParaUsuario(@Valid CadastroUsuarioDto cadastroUsuarioDto, BindingResult result) {
		Usuario usuario = new Usuario();
		usuario.setUsuario(cadastroUsuarioDto.getNome());
		usuario.setEmail(cadastroUsuarioDto.getEmail());
		usuario.setDsSenha(cadastroUsuarioDto.getSenha());
		
		return usuario;
	}


	private void validarDatosExistentes( CadastroUsuarioDto cadastroUsuarioDto, BindingResult result) {
		this.usuarioService.buscarPorNome(cadastroUsuarioDto.getNome()).ifPresent(emp -> result.addError(new ObjectError("usuario","Usuário já existente.")));
		
	}

}
