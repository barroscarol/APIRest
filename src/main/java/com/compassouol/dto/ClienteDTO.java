package com.compassouol.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.compassouol.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório : Para Cadastro de cliente o campo nome do cliente deve estar preenchido")
	@Length(min = 2, max = 30, message = "O nome do cliente deve conter entre 2 e 30 caracteres")
	private String nomeCompleto;

	@NotEmpty(message = "Preenchimento obrigatório : Para Cadastro de cliente o campo sexo deve estar preenchido")
	private String sexo;

	@Past(message = "Preenchimento obrigatório: Para Cadastro de cliente o campo data de nascimento deve estar preenchido")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeNascimento;

	private int idade;

	@NotEmpty(message = "Preenchimento obrigatório:Para Cadastro de cliente  o campo cidade onde reside deve estar preenchido")
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

	public ClienteDTO(Integer id, String nomeCompleto, String sexo, Date dataDeNascimento, int idade,
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

}
