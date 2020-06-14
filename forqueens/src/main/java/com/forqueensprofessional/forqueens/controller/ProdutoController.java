package com.forqueensprofessional.forqueens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forqueensprofessional.forqueens.model.Produto;
import com.forqueensprofessional.forqueens.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
		@Autowired
		private ProdutoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Produto>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Produto> getById(@PathVariable long id ){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nomeProduto/{nomeProduto}")
		public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String nomeProduto){
			return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
		}
		
		@PostMapping
		public ResponseEntity<Produto> post(@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		@PutMapping
		public ResponseEntity<Produto> put(@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
}