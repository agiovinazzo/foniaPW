package gestioneTrafficoTelefonicoPW.services;

import java.util.Date;
import java.util.List;

import gestioneTrafficoTelefonicoPW.models.CallTrackEntity;

public interface CallTrackService {

	public CallTrackEntity saveCallTrack(CallTrackEntity callTrackEntity);
	public List<CallTrackEntity> getAllCallTracks();
	public CallTrackEntity getCallTrackById(Integer id);
	public CallTrackEntity updateCallTrack(CallTrackEntity callTrackEntity, Integer id);
	public void deleteCallTrack(Integer id);
	public Long getSumDurationCall(Integer phone, Date startingTime, Date endingTime);
}