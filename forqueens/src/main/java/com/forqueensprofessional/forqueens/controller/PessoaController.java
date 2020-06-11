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

import com.forqueensprofessional.forqueens.model.Pessoa;
import com.forqueensprofessional.forqueens.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{cd_cpf}")
	public ResponseEntity<Pessoa> GetByCpf(@PathVariable long cd_cpf ){
		return repository.findById(cd_cpf)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomepessoa/{nome}")
	public ResponseEntity<List<Pessoa>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> post (@RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> put (@RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
	}
	
	@DeleteMapping("/{cd_cpf}")
	public void delete(@PathVariable long cd_cpf) {
		repository.deleteById(cd_cpf);
	}
}
