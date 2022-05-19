package gestioneTrafficoTelefonicoPW.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestioneTrafficoTelefonicoPW.exceptions.ResourceNotFoundException;
import gestioneTrafficoTelefonicoPW.models.CustomerEntity;
import gestioneTrafficoTelefonicoPW.repositories.CustomerRepository;
import gestioneTrafficoTelefonicoPW.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}



	@Override
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		
		return customerRepository.save(customerEntity);
	}



	@Override
	public List<CustomerEntity> getAllCustomers() {
		return (List<CustomerEntity>) customerRepository.findAll();
	}



	@Override
	public CustomerEntity getCustomerById(Integer id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
	}



	@Override
	public CustomerEntity updateCustomer(CustomerEntity customerEntity, Integer id) {
		
		CustomerEntity updatedCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
		
		updatedCustomer.setFirstName(customerEntity.getFirstName());
		updatedCustomer.setLastName(customerEntity.getLastName());
		updatedCustomer.setBirthDate(customerEntity.getBirthDate());
		updatedCustomer.setAddress(customerEntity.getAddress());
		
		customerRepository.save(updatedCustomer);
		return updatedCustomer;
	}



	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
		customerRepository.deleteById(id);
	}
}