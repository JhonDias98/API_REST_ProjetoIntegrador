package com.forqueensprofessional.forqueens.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	private long cd_cpf;
	
	@NotNull
	@Size(min = 5, max = 80)
	private String nome;
	
	@NotNull
	@Size(min = 7, max = 80)
	private String nm_email;
	

	@Size(min = 10, max = 12)
	private String nm_celular;
	
	@NotNull
	@Size(min = 6, max = 30)
	private String nm_senha;
	
	@NotNull
	@Size(min = 7, max = 9)
	private String dt_nascimento;

	public long getCd_cpf() {
		return cd_cpf;
	}

	public void setCd_cpf(long cd_cpf) {
		this.cd_cpf = cd_cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNm_email() {
		return nm_email;
	}

	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	}

	public String getNm_celular() {
		return nm_celular;
	}

	public void setNm_celular(String nm_celular) {
		this.nm_celular = nm_celular;
	}

	public String getNm_senha() {
		return nm_senha;
	}

	public void setNm_senha(String nm_senha) {
		this.nm_senha = nm_senha;
	}

	public String getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
}
