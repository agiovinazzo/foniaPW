package gestioneTrafficoTelefonicoPW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestioneTrafficoTelefonicoPW.models.CustomerEntity;

//@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	//	CrudRepository<CustomerEntity, Integer>
}
