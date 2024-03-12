package coms.VaccinationCenterApp.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coms.VaccinationCenterApp.models.Admin;
import coms.VaccinationCenterApp.models.VaccinationCenter;
import coms.VaccinationCenterApp.services.AdminService;
import coms.VaccinationCenterApp.services.VaccinationService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@Autowired
	VaccinationService vs;
	
	@GetMapping(value = "/")
	public String adminLoginPage() {
		return "AdminLogin";
	}
	
	@PostMapping(value = "/userLogin")
	public String adminLoginMethod(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		if(as.SearchAdmin(username, password)) {
			System.out.println("Homepage Login Success");
			List<VaccinationCenter> centerList = vs.findAllCenter();
			for (Iterator<VaccinationCenter> iterator = centerList.iterator(); iterator.hasNext();) {
				VaccinationCenter center = (VaccinationCenter) iterator.next();
				System.out.println("In the for loop");
				System.out.println(center.getCenterId());
				System.out.println(center.getCenterName());
				System.out.println(center.getCenterCity());
			}
			System.out.println("above add attribute");
			model.addAttribute("centerList", centerList);
			System.out.println("below add attribute");
			return "DisplayVaccinationCenter";
		}
		System.out.println("Invalid Login Attemp");
		model.addAttribute("invalidCredentialMessage", "Please enter Correct username and password");
		return "AdminLogin";
	}
	
	@GetMapping("/RegisterAdminPage")
	public String adminRegistrationPageLoad() {
		return "AdminRegister";
	}
	
	@PostMapping(value = "/RegisterAdminPageMethod")
	public String adminRegisterPage(@RequestParam("adminName") String adminName,
			@RequestParam("adminEmail") String adminEmail, @RequestParam("adminPassword") String adminPassword,
			Model model) {
		Admin adminDetail = new Admin();
		adminDetail.setAdminName(adminName);
		adminDetail.setAdminEmail(adminEmail);
		adminDetail.setAdminPassword(adminPassword);

		if (as.AddNewAdmin(adminDetail) == true) {
			System.out.println("Admin added successfully...");
		} else {
			System.out.println("Try Again");
		}
		return "AdminLogin";
	}
	
}
