package gestioneTrafficoTelefonicoPW.services;

import java.util.List;

import gestioneTrafficoTelefonicoPW.models.PhoneEntity;

public interface PhoneService {
	
	public PhoneEntity savePhone(PhoneEntity phoneEntity);
	public List<PhoneEntity> getAllPhones();
	public PhoneEntity getPhoneById(Integer id);
	public PhoneEntity getPhoneByStatus(String status);
	public PhoneEntity updatePhone(PhoneEntity phoneEntity, Integer id);
	public void deletePhone(Integer id);

}
