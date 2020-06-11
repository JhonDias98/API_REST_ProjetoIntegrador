package com.forqueensprofessional.forqueens.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoCompra;
	
	@NotNull
	@Size(max=45)
	private String tipoEntrega;
	
	@NotNull
	private Date dataCompra = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	private int valor;
	
	@NotNull
	private int qtdProduto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoProduto", referencedColumnName= "codigoProduto")
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoCnpj", referencedColumnName= "cd_cnpj")
	private Empresa empresa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoCpf", referencedColumnName= "cd_cpf")
	private Pessoa pessoa;

	public long getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
