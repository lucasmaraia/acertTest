package com.lucas.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucas.test.models.Cliente;
import com.lucas.test.models.Pedido;
import com.lucas.test.repositorys.ClienteRepository;
import com.lucas.test.repositorys.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> findById(Long id){
		return pedidoRepository.findById(id);
	}
	
	public Page<Pedido> findAll(Pageable pageable) {
	    return pedidoRepository.findAll(pageable);
	}
	
	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void delete(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
	public void atualiza(Optional<Pedido> optinalPedido, Pedido pedido) {
		Pedido p = optinalPedido.get();
		p.setDescricao(pedido.getDescricao());
		p.setCliente(clienteRepository.findById(pedido.getCliente().getId()).get());
		p.setValor(pedido.getValor());
		pedidoRepository.save(p);
	}
	
	public void adicionaCliente(Pedido pedido) {
		pedido.setCliente(clienteRepository.findById(pedido.getCliente().getId()).get());
	}

}
