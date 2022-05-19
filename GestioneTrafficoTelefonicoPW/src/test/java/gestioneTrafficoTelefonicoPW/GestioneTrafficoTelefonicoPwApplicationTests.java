package gestioneTrafficoTelefonicoPW;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gestioneTrafficoTelefonicoPW.repositories.CallTrackRepository;

@SpringBootTest(classes = GestioneTrafficoTelefonicoPwApplication.class)
class GestioneTrafficoTelefonicoPwApplicationTests {

	@Autowired
	CallTrackRepository callTrackRepository;



	@Test
	void contextLoads() {
	}

	@Test
	public void testDate() throws Exception {
		String date = "2022-05-18T02:45:47";
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		System.out.println(sdf.parse(date));
	}

}