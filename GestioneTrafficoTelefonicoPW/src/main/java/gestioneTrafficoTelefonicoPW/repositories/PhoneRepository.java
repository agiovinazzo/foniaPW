package gestioneTrafficoTelefonicoPW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestioneTrafficoTelefonicoPW.models.PhoneEntity;

//@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {
	//	CrudRepository<PhoneEntity, Integer>
	public PhoneEntity findByStatus(String status); 

}
