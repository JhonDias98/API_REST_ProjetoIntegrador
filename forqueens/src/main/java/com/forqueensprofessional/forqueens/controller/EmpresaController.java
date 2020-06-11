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

import com.forqueensprofessional.forqueens.model.Empresa;
import com.forqueensprofessional.forqueens.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
@CrossOrigin("*")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{cd_cnpj}")
	public ResponseEntity<Empresa> GetByCnpj(@PathVariable long cd_cnpj ){
		return repository.findById(cd_cnpj)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomecomercial/{comercial}")
	public ResponseEntity<List<Empresa>> GetByNome(@PathVariable String comercial){
		return ResponseEntity.ok(repository.findAllByComercialContainingIgnoreCase(comercial));
	}
	
	@PostMapping
	public ResponseEntity<Empresa> post (@RequestBody Empresa empresa){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(empresa));
	}
	
	@PutMapping
	public ResponseEntity<Empresa> put (@RequestBody Empresa empresa){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(empresa));
	}
	
	@DeleteMapping("/{cd_cnpj}")
	public void delete(@PathVariable long cd_cnpj) {
		repository.deleteById(cd_cnpj);
	}
}