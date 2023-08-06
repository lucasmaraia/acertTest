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
import com.lucas.test.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll(@RequestParam(defaultValue = "false") boolean paginated,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		if (paginated) {
			Pageable pageable = PageRequest.of(page, size);
			Page<Cliente> customerPage = clienteService.findAll(pageable);
			return customerPage.getContent();
		} else {
			return clienteService.findAll();
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> createCustomer(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		Optional<Cliente> optionalcliente = clienteService.findById(id);

		if (optionalcliente.isPresent()) {
			Cliente cliente = optionalcliente.get();
			clienteService.delete(cliente);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> updateCustomer(@PathVariable Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> optinalCliente = clienteService.findById(id);

		if (optinalCliente.isPresent()) {
			clienteService.atualiza(optinalCliente, cliente);
			return ResponseEntity.status(HttpStatus.OK).body(optinalCliente.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
