package coms.VaccinationCenterApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.VaccinationCenterApp.models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}