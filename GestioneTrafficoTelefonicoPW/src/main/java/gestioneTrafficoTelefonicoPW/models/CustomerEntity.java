package gestioneTrafficoTelefonicoPW.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "first_name")
	@NotBlank(message = "Inserire il nome del cliente")
	@Size(max = 20)
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Inserire il cognome del cliente")
	@Size(max = 20)
	private String lastName;

	@Column(name = "birth_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Past
	@NotNull(message = "Inserire la data di nascita del cliente")
	private LocalDate birthDate;

	@Column(name = "address")
	private String address;
}