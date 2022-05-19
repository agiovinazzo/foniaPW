package gestioneTrafficoTelefonicoPW.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import gestioneTrafficoTelefonicoPW.models.CallTrackEntity;
import gestioneTrafficoTelefonicoPW.models.PhoneEntity;

//@Repository
public interface CallTrackRepository extends JpaRepository<CallTrackEntity, Integer> {
	//	CrudRepository<CallTrackEntity, Integer>


	//	@Query(value="SELECT SUM(call_duration)"
	//			+ "	FROM public.call_tracks"
	//			+ "	WHERE starting_time>=:startingTime AND ending_time<=:endingTime", nativeQuery=true)
	//	public Long durationsSum(@Param("phone")Integer phoneId, @Param("startingTime")Date startingTime, @Param("endingTime")Date endingTime);


	public List<CallTrackEntity> findByPhoneAndStartingTimeGreaterThanEqualAndEndingTimeLessThanEqual(@Param("phone") PhoneEntity phone, @Param("startingTime") Date startingTime, @Param("endingTime") Date endingTime);

}
