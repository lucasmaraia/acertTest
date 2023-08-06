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
import com.lucas.test.models.Entrega;
import com.lucas.test.services.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;
	
	
	@GetMapping
	public List<Entrega> findAll(@RequestParam(defaultValue = "false") boolean paginated,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		if (paginated) {
			Pageable pageable = PageRequest.of(page, size);
			Page<Entrega> customerPage = entregaService.findAll(pageable);
			return customerPage.getContent();
		} else {
			return entregaService.findAll();
		}
	}
	
	@PostMapping
	public ResponseEntity<Entrega> createCustomer(@RequestBody Entrega entrega) {
		entregaService.adicionaPedido(entrega);
		entregaService.save(entrega);
		return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
	}
	
	@GetMapping("/{id}")
	public Entrega findById(@PathVariable Long id) {
		return entregaService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteEntrega(@PathVariable Long id) {
		Optional<Entrega> optionalEntrega = entregaService.findById(id);

		if (optionalEntrega.isPresent()) {
			Entrega entrega = optionalEntrega.get();
			entregaService.delete(entrega);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Entrega> updateCustomer(@PathVariable Long id, @RequestBody Entrega entrega) {
		Optional<Entrega> optinalEntrega = entregaService.findById(id);

		if (optinalEntrega.isPresent()) {
			entregaService.atualiza(optinalEntrega, entrega);	
			return ResponseEntity.status(HttpStatus.OK).body(optinalEntrega.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


}
