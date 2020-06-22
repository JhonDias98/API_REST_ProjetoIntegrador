package com.forqueensprofessional.forqueens.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item_Pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigoItemPedido;
	

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "produto_fk"))
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "pedido_fk"))
	private Pedido pedido;
	
	public long getCodigoItemPedido() {
		return codigoItemPedido;
	}

	public void setCodigoItemPedido(long codigoItemPedido) {
		this.codigoItemPedido = codigoItemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoItemPedido ^ (codigoItemPedido >>> 32));
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
		ItemPedido other = (ItemPedido) obj;
		if (codigoItemPedido != other.codigoItemPedido)
			return false;
		return true;
	}

	
	
	
	
}
