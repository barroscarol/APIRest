package com.compassouol.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.compassouol.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO implements Serializable {
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

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {

		id = obj.getId();
		nomeCompleto = obj.getNomeCompleto();
		sexo = obj.getSexo();
		dataDeNascimento = obj.getDataDeNascimento();
		idade = obj.getIdade();
		cidadeOndeReside = obj.getCidadeOndeReside();
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

}
