package com.forqueensprofessional.forqueens.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoCategoria;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String descricao;
	

	public long getCodigoCategoria() {
		return codigoCategoria;
	}


	public void setCodigoCategoria(long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
