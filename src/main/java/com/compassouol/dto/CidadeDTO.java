package com.compassouol.dto;

import java.io.Serializable;

import com.compassouol.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;
	private String estado;

	public CidadeDTO() {
	}

	public CidadeDTO(Cidade obj) {

		id = obj.getId();
		nome = obj.getNome();
		estado = obj.getEstado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
