package com.compassouol.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeCompleto;
	private String sexo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeNascimento;

	private int idade;
	private String cidadeOndeReside;

	public Cliente() {
	}

	public Cliente(Integer id, String nomeCompleto, String sexo, Date dataDeNascimento, int idade,
			String cidadeOndeReside) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.cidadeOndeReside = cidadeOndeReside;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCidadeOndeReside() {
		return cidadeOndeReside;
	}

	public void setCidadeOndeReside(String cidadeOndeReside) {
		this.cidadeOndeReside = cidadeOndeReside;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
