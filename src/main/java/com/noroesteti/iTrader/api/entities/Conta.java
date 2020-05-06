package com.noroesteti.iTrader.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="tb_conta")
public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2111255414021766830L;
	private Long Id;
	private Long cdConta;
	private Long cdContaDigito;
	private Date dataAtualizacao;
	private Date dataCriacao;
	private Usuario Usuario;
	private Corretora Corretora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.Usuario = usuario;
	}	
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Corretora getCorretora() {
		return Corretora;
	}

	public void setCorretora(Corretora corretora) {
		this.Corretora = corretora;
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
	@Column (name="cd_conta",nullable= false)
	public Long getCdConta() {
		return cdConta;
	}
	public void setCdConta(Long cdConta) {
		this.cdConta = cdConta;
	}
	@Column (name="cd_conta_digito",nullable= false)
	public Long getCdContaDigito() {
		return cdContaDigito;
	}
	public void setCdContaDigito(Long cdContaDigito) {
		this.cdContaDigito = cdContaDigito;
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
