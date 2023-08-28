package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Bank;

@RestController
@RequestMapping("bank")
public class Bankcontroller {
	@Autowired
	Bank bank;

	@Autowired
	EmployeeRepo repo;

	@GetMapping
	public Iterable<Bank> getBank() {
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Bank> getIdDetails(@PathVariable String id) {
		return repo.findById(id);
	}
	@PostMapping
	public Bank addAccount(@RequestBody Bank bank) {
		return repo.save(bank);
	}
	@PutMapping("/{id}") 
	  public Bank updateAccount(@PathVariable String id, @RequestBody Bank bank)
	  { 
		  return repo.save(bank); }
	 @DeleteMapping("/{id}")
	  public void deleteAccount(@RequestBody Bank bank) {
		  repo.delete(bank); }
	 

	 
}
