package coms.VaccinationCenterApp.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import coms.VaccinationCenterApp.models.VaccinationCenter;
import coms.VaccinationCenterApp.services.VaccinationService;

@Controller
public class VaccinationCenterController {

	@Autowired
	VaccinationService vs;
	
	@GetMapping(value ="/viewAll")
	public String viewAllVaccinationCenter(Model model) {
		List<VaccinationCenter> centerList = vs.findAllCenter();
		for (Iterator<VaccinationCenter> iterator = centerList.iterator(); iterator.hasNext();) {
			VaccinationCenter center = (VaccinationCenter) iterator.next();
			System.out.println(center.getCenterId());
			System.out.println(center.getCenterName());
			System.out.println(center.getCenterCity());
		}
		
		model.addAttribute("centerList", centerList);
		return "DisplayVaccinationCenter";
	}
	
	@GetMapping(value = "/addVc")
	public String add() {
		return "AddNewVaccinationCenter";
	}
	
	@GetMapping(value = "/addNewVc")
	public String addNewVaccinationCenter(@RequestParam("") String centerName, @RequestParam("") String centerCity) {
		VaccinationCenter center = new VaccinationCenter();
		center.setCenterName(centerName);
		center.setCenterCity(centerCity);
		
		vs.addNewCenter(center);
		
		return "AddNewVaccinationCenter";
	}
	
	@GetMapping(value = "/deleteVc")
	public String DeleteVaccinationCentreById(@RequestParam("centerId") int centerId) {
		vs.deleteCenterById(centerId);
		return "redirect:/viewAll";
	}
	
	@GetMapping(value = "/updateCall")
	public String updateVaccinationCentre(@RequestParam("vaccinationCenterId") int centerId, Model model) {
		VaccinationCenter center = vs.findCenterById(centerId);
		model.addAttribute("center", center);
		return "UpdateVaccinationCenter";
	}
	
	@GetMapping(value = "updateMethod")
	public String updateVaccinationCentreMethod(@ModelAttribute("center") VaccinationCenter updateValueObject, Model model) {
		vs.updateCenter(updateValueObject);
		return "redirect:/viewAll";
	}
}