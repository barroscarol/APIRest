package com.compassouol.dto;

import java.io.Serializable;

import com.compassouol.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeCompleto;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {

		id = obj.getId();
		nomeCompleto = obj.getNomeCompleto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
