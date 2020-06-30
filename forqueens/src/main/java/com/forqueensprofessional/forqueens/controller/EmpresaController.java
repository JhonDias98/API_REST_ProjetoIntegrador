package com.forqueensprofessional.forqueens.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.forqueensprofessional.forqueens.model.Empresa;
import com.forqueensprofessional.forqueens.model.EmpresaLogin;
import com.forqueensprofessional.forqueens.repository.EmpresaRepository;
import com.forqueensprofessional.forqueens.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> GetAll(){
		return ResponseEntity.ok(empresaRepository.findAll());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<EmpresaLogin> Autentication(@RequestBody EmpresaLogin empresa) {
		return empresaService.Logar(empresa).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Empresa> Post(@RequestBody Empresa empresa){
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.CadastrarEmpresa(empresa));
	}
	
	@PutMapping
	public ResponseEntity<Empresa> put(@RequestBody Empresa empresa){
		return ResponseEntity.status(HttpStatus.OK).body(empresaRepository.save(empresa));
	}

}