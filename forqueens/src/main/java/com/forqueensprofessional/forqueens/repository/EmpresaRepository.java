package com.forqueensprofessional.forqueens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forqueensprofessional.forqueens.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	public List<Empresa>findAllByComercialContainingIgnoreCase(String comercial);
}