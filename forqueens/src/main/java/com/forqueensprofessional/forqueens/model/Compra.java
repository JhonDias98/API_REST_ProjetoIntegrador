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
@Table(name = "Compra")
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
	private double valor;
	
	@NotNull
	private int qtdProduto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoProduto", referencedColumnName= "codigoProduto")
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoCnpj", referencedColumnName= "cnpj")
	private Empresa empresa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoCpf", referencedColumnName= "cpf")
	private Usuario usuario;

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
