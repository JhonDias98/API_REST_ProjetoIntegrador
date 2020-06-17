package com.forqueensprofessional.forqueens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forqueensprofessional.forqueens.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
}