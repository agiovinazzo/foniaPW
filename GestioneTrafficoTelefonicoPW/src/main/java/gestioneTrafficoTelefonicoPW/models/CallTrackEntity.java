package gestioneTrafficoTelefonicoPW.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "call_tracks")
@Data
public class CallTrackEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "call_tracks_id")
	private Integer callTracksId;

	@NotNull(message = "inserire orario di inizio chiamata")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "starting_time")
	@Past
	private Date startingTime;
	
	@NotNull(message = "inserire orario di fine chiamata")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "ending_time")
	@Past
	private Date endingTime;
	
	@NotBlank(message = "Inserire il numero di telefono chiamato")
	@Column(name = "called_number")
	private String calledNumber;
	
	
	@NotNull(message = "inserire durata della chiamata")
	@Column(name = "call_duration")
	private Long callDuration;
	
	@ManyToOne
	@JoinColumn(name = "phone_id")
	@NotNull(message = "Inserire il Phone id")
	private PhoneEntity phone;
}