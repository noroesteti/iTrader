package com.noroesteti.iTrader.api.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class CadastroUsuarioDto {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public CadastroUsuarioDto() {
			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter de 3 a 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Senha não pode ser vazio.")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
	return "";
	}
	
	
}
