package gestioneTrafficoTelefonicoPW.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestioneTrafficoTelefonicoPW.models.CustomerEntity;
import gestioneTrafficoTelefonicoPW.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


	@Autowired
	private CustomerService customerService;


	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@PostMapping
	public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerEntity customerEntity) {
		return new ResponseEntity<CustomerEntity>(customerService.saveCustomer(customerEntity), HttpStatus.CREATED);
	}

	@GetMapping
	public List<CustomerEntity> getAllCustomers() {
		return customerService.getAllCustomers();
	}


	@GetMapping("{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Integer customerId) {
		return new ResponseEntity<CustomerEntity>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}


	@PutMapping("{id}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable("id") Integer customerId, @RequestBody CustomerEntity customerEntity) {
		return new ResponseEntity<CustomerEntity>(customerService.updateCustomer(customerEntity, customerId), HttpStatus.OK);
	}


	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Cliente eliminato con successo", HttpStatus.OK);
	}
}