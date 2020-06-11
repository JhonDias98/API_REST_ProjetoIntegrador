package com.forqueensprofessional.forqueens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forqueensprofessional.forqueens.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	public List<Compra> findAllByCodigoCompra(long codigoCompra);
	
}
