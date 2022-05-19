package gestioneTrafficoTelefonicoPW.servicesImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestioneTrafficoTelefonicoPW.exceptions.ResourceNotFoundException;
import gestioneTrafficoTelefonicoPW.models.CallTrackEntity;
import gestioneTrafficoTelefonicoPW.models.PhoneEntity;
import gestioneTrafficoTelefonicoPW.repositories.CallTrackRepository;
import gestioneTrafficoTelefonicoPW.repositories.PhoneRepository;
import gestioneTrafficoTelefonicoPW.services.CallTrackService;

@Service
public class CallTrackServiceImpl implements CallTrackService {

	@Autowired
	private CallTrackRepository callTrackRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;


	@Autowired
	public CallTrackServiceImpl(CallTrackRepository callTrackRepository) {
		super();
		this.callTrackRepository = callTrackRepository;
	}



	@Override
	public CallTrackEntity saveCallTrack(CallTrackEntity callTrackEntity) {

		callTrackEntity.setCallDuration((callTrackEntity.getEndingTime().getTime() - callTrackEntity.getStartingTime().getTime()) / 1000);
		return callTrackRepository.save(callTrackEntity);
	}



	@Override
	public List<CallTrackEntity> getAllCallTracks() {

		return (List<CallTrackEntity>) callTrackRepository.findAll();
	}



	@Override
	public CallTrackEntity getCallTrackById(Integer id) {
		return callTrackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tracciamento chiamata", "id", id));
	}



	@Override
	public CallTrackEntity updateCallTrack(CallTrackEntity callTrackEntity, Integer id) {
		CallTrackEntity updatedCallTrack = callTrackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tracciamento chiamata", "id", id));

		updatedCallTrack.setStartingTime(callTrackEntity.getStartingTime());
		updatedCallTrack.setEndingTime(callTrackEntity.getEndingTime());
		updatedCallTrack.setCalledNumber(callTrackEntity.getCalledNumber());
		updatedCallTrack.setCallDuration(callTrackEntity.getCallDuration());
		updatedCallTrack.setPhone(callTrackEntity.getPhone());

		callTrackRepository.save(updatedCallTrack);
		return updatedCallTrack;
	}



	@Override
	public void deleteCallTrack(Integer id) {
		callTrackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tracciamento chiamata", "id", id));
		callTrackRepository.deleteById(id);
	}



	@Override
	public Long getSumDurationCall(Integer phone, Date startingTime, Date endingTime) {
		PhoneEntity phoneEntity = phoneRepository.findById(phone).orElse(null);
		System.out.println("phone: " + phone);
		System.out.println("data inizio: " + startingTime);
		System.out.println("data fine: " + endingTime);
		List<CallTrackEntity> list = callTrackRepository.findByPhoneAndStartingTimeGreaterThanEqualAndEndingTimeLessThanEqual(phoneEntity, startingTime, endingTime);
		
		System.out.println("trovate: " + list.size() + " righe.");
		
		Long totMinuti = 0L;
		
		for(int x = 0; x<list.size(); x++) {
			CallTrackEntity callTrackEntity = list.get(x);
			totMinuti += callTrackEntity.getCallDuration();
			System.out.println(callTrackEntity.toString());
		}
		System.out.println(totMinuti + " minuti");
		return totMinuti;
 	}
}