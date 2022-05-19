package gestioneTrafficoTelefonicoPW.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import gestioneTrafficoTelefonicoPW.models.CallTrackEntity;
import gestioneTrafficoTelefonicoPW.services.CallTrackService;

@RestController
@RequestMapping("/api/calltracks")
public class CallTrackController {

	@Autowired
	private CallTrackService callTrackService;


	@Autowired
	public CallTrackController(CallTrackService callTrackService) {
		super();
		this.callTrackService = callTrackService;
	}


	@PostMapping
	public ResponseEntity<CallTrackEntity> saveCallTrack(@RequestBody CallTrackEntity callTrackEntity) {
		return new ResponseEntity<CallTrackEntity>(callTrackService.saveCallTrack(callTrackEntity), HttpStatus.CREATED);
	}

	@GetMapping
	public List<CallTrackEntity> getAllCallTracks() {
		return callTrackService.getAllCallTracks();
	}

	@GetMapping("{id}")
	public ResponseEntity<CallTrackEntity> getCallTrackById(@PathVariable("id") Integer callTrackId) {
		return new ResponseEntity<CallTrackEntity>(callTrackService.getCallTrackById(callTrackId), HttpStatus.OK);
	}


	@PutMapping("{id}")
	public ResponseEntity<CallTrackEntity> updateCallTrack(@PathVariable("id") Integer callTrackId, @RequestBody CallTrackEntity callTrackEntity) {
		return new ResponseEntity<CallTrackEntity>(callTrackService.updateCallTrack(callTrackEntity, callTrackId), HttpStatus.OK);
	}


	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCallTrack(@PathVariable("id") Integer callTrackId) {
		callTrackService.deleteCallTrack(callTrackId);
		return new ResponseEntity<String>("Tracciamento della chiamata eliminato con successo", HttpStatus.OK);
	}




	@GetMapping("{phone}/{start}/{end}")
	public Long getSumDurationCall(@PathVariable("phone") Integer phone, @PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date startingTime, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date endingTime) {	
		return callTrackService.getSumDurationCall(phone, startingTime, endingTime);
	}
}