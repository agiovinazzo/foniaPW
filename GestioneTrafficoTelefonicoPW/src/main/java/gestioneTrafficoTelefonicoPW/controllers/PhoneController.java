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

import gestioneTrafficoTelefonicoPW.models.PhoneEntity;
import gestioneTrafficoTelefonicoPW.services.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
	
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	public PhoneController(PhoneService phoneService) {
		super();
		this.phoneService = phoneService;
	}
	
	
	@PostMapping
	public ResponseEntity<PhoneEntity> savePhone(@RequestBody PhoneEntity phoneEntity) {
		return new ResponseEntity<PhoneEntity>(phoneService.savePhone(phoneEntity), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<PhoneEntity> getAllPhones() {
		return phoneService.getAllPhones();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<PhoneEntity> getPhoneById(@PathVariable("id") Integer phoneId) {
		return new ResponseEntity<PhoneEntity>(phoneService.getPhoneById(phoneId), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<PhoneEntity> updatePhone(@PathVariable("id") Integer phoneId, @RequestBody PhoneEntity phoneEntity) {
		return new ResponseEntity<PhoneEntity>(phoneService.updatePhone(phoneEntity, phoneId), HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePhone(@PathVariable("id") Integer phoneId) {
		phoneService.deletePhone(phoneId);
		return new ResponseEntity<String>("Dati linea telefono eliminati con successo", HttpStatus.OK);
	}
}
