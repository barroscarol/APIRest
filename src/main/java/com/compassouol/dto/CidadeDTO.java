package com.compassouol.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.compassouol.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório - O nome da cidade deve ser Preenchido")
	@Length(min=2,max =30,message = "O nome da cidade deve ter entre 2 e 30 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório - O nomo da estado deve ser Preenchido")
	@Length(min=2,max =30,message = "O nome do estado deve ter entre 2 e 30 caracteres")
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
