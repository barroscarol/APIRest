package com.compassouol.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.compassouol.domain.Cliente;

public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório - Para atualização de dados cadastrais, o nome do cliente deve ser preenchido")
	
	@Length(min = 2, max = 30, message = "O nome do cliente deve conter entre 2 e 30 caracteres")
	private String nomeCompleto;

	public ClienteNewDTO() {
	}

	public ClienteNewDTO(Cliente obj) {

		id = obj.getId();
		nomeCompleto = obj.getNomeCompleto();
	}

	public ClienteNewDTO(Integer id, String nomeCompleto) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
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
