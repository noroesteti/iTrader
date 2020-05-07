package com.noroesteti.iTrader.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_corretora")
public class Corretora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3857855487239036652L;
	private Long Id;
	private Long cdCorretora;
	private String dsCorretora;	
	private Date dataAtualizacao;
	private Date dataCriacao;
	private List<Conta> contas;
	
	@OneToMany(mappedBy = "corretora", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	@Column (name="cd_corretora",nullable= false)
	public Long getCdCorretora() {
		return cdCorretora;
	}
	public void setCdCorretora(Long cdCorretora2) {
		this.cdCorretora = cdCorretora2;
	}
	@Column (name="ds_corretora",nullable= false)
	public String getDsCorretora() {
		return dsCorretora;
	}
	public void setDsCorretora(String dsCorretora) {
		this.dsCorretora = dsCorretora;
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
