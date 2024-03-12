package coms.VaccinationCenterApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin_details")
@Getter
@Setter
public class Admin {
	
	@Id
	@GeneratedValue
	private int adminId;
	
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	
}
