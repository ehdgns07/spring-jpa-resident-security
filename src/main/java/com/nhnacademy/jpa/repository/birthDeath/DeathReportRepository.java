package com.nhnacademy.jpa.repository.birthDeath;

import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeathReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

}
