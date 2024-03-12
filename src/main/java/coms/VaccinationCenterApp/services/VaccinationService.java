package coms.VaccinationCenterApp.services;

import java.util.List;

import coms.VaccinationCenterApp.models.VaccinationCenter;

public interface VaccinationService {
	
	public boolean addNewCenter(VaccinationCenter vaccinationCenter);
	
	public List<VaccinationCenter> findAllCenter();
	
	public VaccinationCenter findCenterById(int centerId);
	
	public boolean updateCenter(VaccinationCenter vaccinationCenter);
	
	public void deleteCenterById(int centerId);
	
}
