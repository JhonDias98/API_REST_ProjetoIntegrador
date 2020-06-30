package com.forqueensprofessional.forqueens.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.forqueensprofessional.forqueens.model.Empresa;
import com.forqueensprofessional.forqueens.repository.EmpresaRepository;

@Service
public abstract class EmpresaDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<Empresa> userEmpresa = empresaRepository.findByEmail(userEmail);
		userEmpresa.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found."));
		return userEmpresa.map(EmpresaDetailsImpl::new).get();
	}
}
