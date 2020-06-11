package com.forqueensprofessional.forqueens.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	@Id
	private long cd_cnpj;
	
	@NotNull
	@Size(min = 5, max = 80)
	private String nm_comprador;
	
	@NotNull
	@Size(min = 7, max = 80)
	private String nm_email;
	
	@NotNull
	@Size(min = 5, max = 80)
	private String comercial;
	
	@NotNull
	@Size(min = 6, max = 30)
	private String nm_senha;
	
	@NotNull
	private long nm_inscricao_estadual;
	
	@NotNull
	@Size(min = 5, max = 120)
	private String nm_razao_social;
	
	@Size(min = 10, max = 11)
	private String nm_telefone_comercial;

	public long getCd_cnpj() {
		return cd_cnpj;
	}

	public void setCd_cnpj(long cd_cnpj) {
		this.cd_cnpj = cd_cnpj;
	}

	public String getNm_comprador() {
		return nm_comprador;
	}

	public void setNm_comprador(String nm_comprador) {
		this.nm_comprador = nm_comprador;
	}

	public String getNm_email() {
		return nm_email;
	}

	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getNm_senha() {
		return nm_senha;
	}

	public void setNm_senha(String nm_senha) {
		this.nm_senha = nm_senha;
	}

	public long getNm_inscricao_estadual() {
		return nm_inscricao_estadual;
	}

	public void setNm_inscricao_estadual(long nm_inscricao_estadual) {
		this.nm_inscricao_estadual = nm_inscricao_estadual;
	}

	public String getNm_razao_social() {
		return nm_razao_social;
	}

	public void setNm_razao_social(String nm_razao_social) {
		this.nm_razao_social = nm_razao_social;
	}

	public String getNm_telefone_comercial() {
		return nm_telefone_comercial;
	}

	public void setNm_telefone_comercial(String nm_telefone_comercial) {
		this.nm_telefone_comercial = nm_telefone_comercial;
	}
	
	
}
