package com.nhnacademy.jpa.repository.birthDeath;

import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BirthDeathReportRepository extends BirthReportRepositoryCustom, JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
//, nativeQuery = true
    @Transactional
    @Modifying
    @Query("update BirthDeathReportResident set emailAddress = ?1, phoneNumber = ?2 where pk.reportResidentSerialNo = ?3 and pk.residentSerialNo = ?4")
    Integer updateBirthReport(String emailAddress, String phoneNumber, Integer serialNumber, Integer targetSerialNumber);

    @Transactional
    @Modifying
    @Query(value = "update BirthDeathReportResident set emailAddress = ?1, phoneNumber = ?2, deathReportQualificationsCode = ?5 where  pk.reportResidentSerialNo = ?3 and pk.residentSerialNo = ?4")
    Integer updateDeathReport(String emailAddress, String phoneNumber, Integer serialNumber, Integer targetSerialNumber, String deathReportQualificationsCode);

}
