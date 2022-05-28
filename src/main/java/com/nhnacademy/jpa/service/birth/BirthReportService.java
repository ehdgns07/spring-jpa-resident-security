package com.nhnacademy.jpa.service.birth;

import com.nhnacademy.jpa.domain.BirthReportDto;
import com.nhnacademy.jpa.domain.BirthReportModifyDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;

public interface BirthReportService {
    BirthDeathReportResident createBirthReport(BirthReportDto birthReportDto, Integer serialNumber);

    Integer modifyBirthReport(BirthReportModifyDto birthReportModifyDto, Integer serialNumber, Integer targetSerialNumber);

    void removeBirthReport(Integer serialNumber, Integer targetSerialNumber);
}
