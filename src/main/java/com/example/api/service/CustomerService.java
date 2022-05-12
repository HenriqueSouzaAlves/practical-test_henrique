package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	public Page<Customer> findAllCustomers(Pageable pageabe) {
		return repository.findAll(pageabe);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}
	
	
	 public Customer create(Customer customer) { 
		 return repository.save(customer);
	}
	 
	 
	 public void deleteById(Long id) { 
		 repository.deleteById(id);
	}
	 
	 public void update(Customer customer) { 
		 repository.save(customer);
	}

}
