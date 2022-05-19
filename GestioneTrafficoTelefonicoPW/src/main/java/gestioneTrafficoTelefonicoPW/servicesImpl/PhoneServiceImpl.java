package gestioneTrafficoTelefonicoPW.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestioneTrafficoTelefonicoPW.exceptions.ResourceNotFoundException;
import gestioneTrafficoTelefonicoPW.models.PhoneEntity;
import gestioneTrafficoTelefonicoPW.repositories.PhoneRepository;
import gestioneTrafficoTelefonicoPW.services.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;



	@Autowired
	public PhoneServiceImpl(PhoneRepository phoneRepository) {
		super();
		this.phoneRepository = phoneRepository;
	}




	@Override
	public PhoneEntity savePhone(PhoneEntity phoneEntity) {

		return phoneRepository.save(phoneEntity);
	}




	@Override
	public List<PhoneEntity> getAllPhones() {

		return (List<PhoneEntity>) phoneRepository.findAll();
	}




	@Override
	public PhoneEntity getPhoneById(Integer id) {
		return phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Linea Telefonica", "id", id));
	}




	@Override
	public PhoneEntity getPhoneByStatus(String status) {
		PhoneEntity phoneEntity = phoneRepository.findByStatus(status);
		return phoneEntity;
	}




	@Override
	public PhoneEntity updatePhone(PhoneEntity phoneEntity, Integer id) {
		PhoneEntity updatedPhone = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Linea Telefonica", "id", id));;

		updatedPhone.setNumber(phoneEntity.getNumber());
		updatedPhone.setType(phoneEntity.getType());
		updatedPhone.setStatus(phoneEntity.getStatus());
		updatedPhone.setCustomer(phoneEntity.getCustomer());

		phoneRepository.save(updatedPhone);
		return updatedPhone;
	}




	@Override
	public void deletePhone(Integer id) {
		phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Linea Telefonica", "id", id));
		phoneRepository.deleteById(id);
	}
}
