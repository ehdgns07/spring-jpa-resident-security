package com.nhnacademy.jpa.repository.birthDeath;

import com.nhnacademy.jpa.domain.BirthReportModifyDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BirthReportRepository extends BirthReportRepositoryCustom, JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

    @Transactional
    @Modifying
    @Query(value = "update birth_death_report_resident set email_address = ?1, phone_number = ?2 where report_resident_serial_number = ?3 and resident_serial_number = ?4", nativeQuery = true)
    Integer updateBirthReport(String emailAddress, String phoneNumber, Integer serialNumber, Integer targetSerialNumber);
}
