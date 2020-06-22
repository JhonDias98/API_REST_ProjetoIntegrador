package com.forqueensprofessional.forqueens.dto;

public class ItemPedidoDTO {

	private Long codigoItemPedido;
	
	private Long codigoProduto;
	
	private Long codigoPedido;

	public Long getCodigoItemPedido() {
		return codigoItemPedido;
	}

	public void setCodigoItemPedido(Long codigoItemPedido) {
		this.codigoItemPedido = codigoItemPedido;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public ItemPedidoDTO(Long codigoItemPedido, Long codigoProduto, Long codigoPedido) {
		super();
		this.codigoItemPedido = codigoItemPedido;
		this.codigoProduto = codigoProduto;
		this.codigoPedido = codigoPedido;
	}


	
	
	
}
