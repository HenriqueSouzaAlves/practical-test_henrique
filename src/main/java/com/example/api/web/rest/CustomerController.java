package com.example.api.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Customer;
import com.example.api.exceptionhandler.CustomerNotFoundException;
import com.example.api.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
@Api(value = "API REST Customers")
@CrossOrigin(origins="*")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation(value = "Retorna lista de clientes")
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/paginas")
	@ApiOperation(value = "Retorna clientes com a paginação")
	public Page<Customer> findAllCustomer(Pageable pageable) {
		return service.findAllCustomers(pageable);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna cliente pelo Id")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException());
	}
	
	
	@PostMapping
	@ApiOperation(value = "Cria um Cliente")
	public Customer create(@RequestBody @Valid Customer customer) {
		return service.create(customer);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta o cliente pelo Id")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		
		return service.findById(id)
				.map(record -> {
					service.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new CustomerNotFoundException());
				
		}
		
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza o cliente pelo Id")
	public ResponseEntity<Customer> update(@PathVariable("id") Long id, 
											@RequestBody Customer customer) {

		return service.findById(id)
				.map(record -> {
					record.setId(customer.getId());
					record.setName(customer.getName());
					record.setEmail(customer.getEmail());
					Customer updated = service.create(customer);
					return ResponseEntity.ok().body(updated);
				}).orElseThrow(() -> new CustomerNotFoundException());
	}
	
	

}
