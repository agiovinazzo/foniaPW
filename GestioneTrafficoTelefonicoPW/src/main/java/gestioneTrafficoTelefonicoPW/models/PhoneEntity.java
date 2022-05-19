package gestioneTrafficoTelefonicoPW.models;

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
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "phones")
@Data
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Integer phoneId;

	@NotBlank(message = "Inserire il numero di telefono")
	@Column(name = "number", unique = true)
	private String number;

	@NotBlank(message = "Specificare se si tratta di telefono fisso o cellulare")
	@Column(name = "type")
	@Size(max = 15)
	private String type;

	@NotBlank(message = "Specificare se lo status della linea telefonica è attivo, sospeso o cessato")
	@Column(name = "status")
	@Size(max = 15)
	private String status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@NotNull(message = "Inserire il Customer id")
	private CustomerEntity customer;
}