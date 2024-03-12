package coms.VaccinationCenterApp.services;

import coms.VaccinationCenterApp.models.Admin;

public interface AdminService {
	public boolean AddNewAdmin(Admin admin);
	public boolean SearchAdmin(String Email, String Password);
}
