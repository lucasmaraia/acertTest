package com.lucas.test.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucas.test.models.Cliente;
import com.lucas.test.models.Pedido;
import com.lucas.test.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
                                                                                                                                                                                                                                             	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> createCustomer(@RequestBody Pedido pedido) {
		pedidoService.adicionaCliente(pedido);
		pedidoService.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
	}
	
	@GetMapping
	public List<Pedido> findAll(@RequestParam(defaultValue = "false") boolean paginated,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		if (paginated) {
			Pageable pageable = PageRequest.of(page, size);
			Page<Pedido> customerPage = pedidoService.findAll(pageable);
			return customerPage.getContent();
		} else {
			return pedidoService.findAll();
		}
	}
	
	@GetMapping("/{id}")
	public Pedido findById(@PathVariable Long id) {
		return pedidoService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		Optional<Pedido> optionalPedido = pedidoService.findById(id);

		if (optionalPedido.isPresent()) {
			Pedido pedido = optionalPedido.get();
			pedidoService.delete(pedido);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pedido> updateCustomer(@PathVariable Long id, @RequestBody Pedido pedido) {
		Optional<Pedido> optinalPedido = pedidoService.findById(id);

		if (optinalPedido.isPresent()) {
			pedidoService.atualiza(optinalPedido, pedido);	
			return ResponseEntity.status(HttpStatus.OK).body(optinalPedido.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


}
