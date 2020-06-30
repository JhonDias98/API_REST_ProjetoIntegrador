package com.forqueensprofessional.forqueens.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.forqueensprofessional.forqueens.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	public Optional<Empresa> findByEmail(String email);
}