package coms.VaccinationCenterApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.VaccinationCenterApp.models.VaccinationCenter;
import coms.VaccinationCenterApp.repository.VaccinationCenterRepo;

@Service
public class VaccinationCenterImpl implements VaccinationService {
	
	@Autowired
	VaccinationCenterRepo vr;

	@Override
	public boolean addNewCenter(VaccinationCenter vaccinationCenter) {
		if(vaccinationCenter != null) {
			vr.save(vaccinationCenter);
			return true;
		}
		return false;
	}

	@Override
	public List<VaccinationCenter> findAllCenter() {
		List<VaccinationCenter> centerList = vr.findAll();
		return centerList;
	}

	@Override
	public VaccinationCenter findCenterById(int centerId) {
		Optional<VaccinationCenter> center = vr.findById(centerId);
		if(center.isPresent()) {
			return center.get();
		}
		return null;
	}

	@Override
	public boolean updateCenter(VaccinationCenter vaccinationCenter) {
		if(vaccinationCenter != null) {
			vr.saveAndFlush(vaccinationCenter);
			return true;
		}
		return false;
	}

	@Override
	public void deleteCenterById(int centerId) {
		Optional<VaccinationCenter> center = vr.findById(centerId);
		if(center.isPresent()) {
			vr.deleteById(centerId);
		}
		return ;
	}

}
