package com.forqueensprofessional.forqueens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.forqueensprofessional.forqueens.dto.ItemPedidoDTO;
import com.forqueensprofessional.forqueens.model.ItemPedido;
import com.forqueensprofessional.forqueens.model.Produto;
import com.forqueensprofessional.forqueens.repository.ItemPedidoRepository;
import com.forqueensprofessional.forqueens.repository.ProdutoRepository;

@RestController
@RequestMapping("/itempedido")
@CrossOrigin("*")
public class ItemPedidoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	private ItemPedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound()
				.build());
	}
	
	@PostMapping
	public ItemPedido salvar(@RequestBody ItemPedidoDTO dto) {
		long codigoProduto = dto.getCodigoProduto();
		
		Produto produto = produtoRepository.findById(codigoProduto)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto Inexixtente"));
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setCodigoItemPedido(dto.getCodigoItemPedido());
		itemPedido.setProduto(produto); 
		
		
		
		return repository.save(itemPedido);
	}

}
