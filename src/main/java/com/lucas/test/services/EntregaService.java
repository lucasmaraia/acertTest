package com.lucas.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucas.test.models.Entrega;
import com.lucas.test.repositorys.EntregaRepository;
import com.lucas.test.repositorys.PedidoRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Entrega> findAll(){
		return entregaRepository.findAll();
	}
	
	public Optional<Entrega> findById(Long id){
		return entregaRepository.findById(id);
	}
	
	public Page<Entrega> findAll(Pageable pageable) {
	    return entregaRepository.findAll(pageable);
	}
	
	public void save(Entrega entrega) {
		entregaRepository.save(entrega);
	}
	
	public void delete(Entrega entrega) {
		entregaRepository.delete(entrega);
	}
	
	public void adicionaPedido(Entrega entrega) {
		entrega.setPedido(pedidoRepository.findById(entrega.getPedido().getId()).get());
		
	}
	
	public void atualiza(Optional<Entrega> optinalEntrega, Entrega entrega) {
		Entrega e = optinalEntrega.get();
		e.setDescricao(entrega.getDescricao());
		e.setEndereco(entrega.getEndereco());
		e.setPedido(pedidoRepository.findById(entrega.getPedido().getId()).get());		
		entregaRepository.save(e);
	}

}
