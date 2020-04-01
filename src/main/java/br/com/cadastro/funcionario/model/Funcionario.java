package br.com.cadastro.funcionario.model;

import com.totvs.tjf.api.jpa.simplefilter.SimpleFilterSupport;
import com.totvs.tjf.api.jpa.simplefilter.SimpleFilterSupportAllow;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "funcionario")
public class Funcionario implements SimpleFilterSupport<Funcionario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SimpleFilterSupportAllow
	private Long id;

	@NotBlank(message = "{funcionario.nome.NotBlank}")
	private String nome;
	private String cpf;
	private String email;
	private BigDecimal salario;
	private String telefone;
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	public Funcionario() {}

	public Funcionario(String nome, String cpf, String email, BigDecimal salario, String telefone,
			Cargo cargo) {
		this.id = null;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.salario = salario;
		this.telefone = telefone;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getTelefone() {
		return telefone;
	}

	public Cargo getCargo() {
		return cargo;
	}

}
