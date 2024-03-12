package coms.VaccinationCenterApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vaccination_Center_Info")
@Getter
@Setter
public class VaccinationCenter {
	
	@Id
	@GeneratedValue
	private int centerId;
	
	private String centerName;
	private String centerCity;
}
