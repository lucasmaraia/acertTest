package com.lucas.test.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.lucas.test.models.Cliente;
import com.lucas.test.repositorys.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id){
		return clienteRepository.findById(id);
	}
	
	public Page<Cliente> findAll(Pageable pageable) {
	    return clienteRepository.findAll(pageable);
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public void atualiza(Optional<Cliente> optinalCliente, Cliente cliente) {
		Cliente c = optinalCliente.get();
		c.setCnpj(cliente.getCnpj());
		c.setNome(cliente.getNome());
		c.setRazaoSocial(cliente.getRazaoSocial());
		clienteRepository.save(c);
	}
	

}
