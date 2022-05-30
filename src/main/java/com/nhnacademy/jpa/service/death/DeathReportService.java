package com.nhnacademy.jpa.service.death;

import com.nhnacademy.jpa.domain.DeathReportDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;

public interface DeathReportService {

    BirthDeathReportResident createDeathReport(DeathReportDto deathReportDto, Integer serialNumber);

    Integer modifyDeathReport(DeathReportDto deathReportDto, Integer serialNumber, Integer targetSerialNumber);
}
