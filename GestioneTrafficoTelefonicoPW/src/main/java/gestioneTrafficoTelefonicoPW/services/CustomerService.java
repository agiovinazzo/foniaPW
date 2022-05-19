package gestioneTrafficoTelefonicoPW.services;

import java.util.List;

import gestioneTrafficoTelefonicoPW.models.CustomerEntity;

public interface CustomerService {

	public CustomerEntity saveCustomer(CustomerEntity customerEntity);
	public List<CustomerEntity> getAllCustomers();
	public CustomerEntity getCustomerById(Integer id);
	public CustomerEntity updateCustomer(CustomerEntity customerEntity, Integer id);
	public void deleteCustomer(Integer id);
}