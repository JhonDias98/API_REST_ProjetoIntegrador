package com.forqueensprofessional.forqueens.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.forqueensprofessional.forqueens.model.Empresa;
import com.forqueensprofessional.forqueens.model.EmpresaLogin;
import com.forqueensprofessional.forqueens.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	public Empresa CadastrarEmpresa(Empresa empresa) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(empresa.getSenha());
		empresa.setSenha(senhaEncoder);
		
		return repository.save(empresa);
	}
	
	public Optional<EmpresaLogin> Logar(EmpresaLogin empresaLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Empresa> empresa = repository.findByEmail(empresaLogin.getEmail());
		
		if(empresa.isPresent() == false) {
			return Optional.empty();
		}
			
		if(encoder.matches(empresaLogin.getSenha(), empresa.get().getSenha()) == false) {
			return Optional.empty();
		}
		
		String auth = empresaLogin.getEmail() + ":" + empresaLogin.getSenha();
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
				
		EmpresaLogin empresaLogada = new EmpresaLogin();
		
		empresaLogada.setId(empresa.get().getId());
		empresaLogada.setCnpj(empresa.get().getCnpj());
		empresaLogada.setEmail(empresa.get().getEmail());
		empresaLogada.setRazaoSocial(empresa.get().getRazaoSocial());
		empresaLogada.setNomeComercial(empresa.get().getNomeComercial());
		empresaLogada.setInscricaoEstadual(empresa.get().getInscricaoEstadual());
		empresaLogada.setTelefoneComercial(empresa.get().getTelefoneComercial());
		empresaLogada.setNomeComprador(empresa.get().getNomeComprador());
		empresaLogada.setSenha(empresa.get().getSenha());
		empresaLogada.setToken(authHeader);
				
		return Optional.ofNullable(empresaLogada);
	}
}