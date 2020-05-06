package com.noroesteti.iTrader.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.noroesteti.iTrader.api.enums.PerfilEnum;



@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6114605532684663646L;
	private Long Id;	
	private String nomeUsuario;
	private PerfilEnum dsPerfil;
	private String dsEmail;
	private String dsSenha;	
	private Date dataAtualizacao;
	private Date dataCriacao;
	private List<Conta> contas;
	
	@OneToMany(mappedBy = "tb_usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
		
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	@Column (name="id",nullable= false)
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
		
	
	@Column (name="ds_usuario",nullable = false)
	public String getUsuario() {
		return nomeUsuario;
	}
	public void setUsuario(String usuario) {
		this.nomeUsuario = usuario;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_perfil",nullable=true)
	public PerfilEnum getDsPerfil() {
		return dsPerfil;
	}
	public void setDsPerfil(PerfilEnum dsPerfil) {
		this.dsPerfil = dsPerfil;
	}
	
	@Column(name="ds_email",nullable=true)
	public String getEmail() {
		return dsEmail;
	}
	public void setEmail(String Email) {
		this.dsEmail = Email;
	}
	
	@Column(name="ds_senha",nullable=true)
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	
	@Column (name="dt_atualizacao",nullable= false)
	public Date getdataAtualizacao() {
		return dataAtualizacao;
	}
	public void setdataAtualizacao(Date data_atualizacao) {
		this.dataAtualizacao = data_atualizacao;
	}
	
	@Column (name="dt_criacao",nullable= false)
	public Date getdataCriacao() {
		return dataCriacao;
	}
	public void setdataCriacao(Date data_criacao) {
		this.dataCriacao = data_criacao;
	}

	
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
    
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataAtualizacao = atual;
		dataCriacao	   = atual;
	}
	
	@Override
	public String toString() {
	return "";
	}
	

	
	
}
