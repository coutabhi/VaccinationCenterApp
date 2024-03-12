package coms.VaccinationCenterApp.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.VaccinationCenterApp.models.Admin;
import coms.VaccinationCenterApp.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminRepo;

	@Override
	public boolean AddNewAdmin(Admin admin) {
		if (admin != null) {
			adminRepo.save(admin);
			return true;
		}
		return false;
	}

	@Override
	public boolean SearchAdmin(String Email, String Password) {
		List<Admin> adminList = adminRepo.findAll();
		for (Iterator<Admin> iterator = adminList.iterator(); iterator.hasNext();) {
			Admin admin = (Admin) iterator.next();
			if (Email.equals(admin.getAdminEmail()) && Password.equals(admin.getAdminPassword())) {
				return true;
			}
		}
		return false;
	}

}
