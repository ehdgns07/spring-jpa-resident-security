package com.nhnacademy.jpa.restcontroller.birthdeathreport;

import com.nhnacademy.jpa.domain.death.DeathReportDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import com.nhnacademy.jpa.service.death.DeathReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/death")
@RequiredArgsConstructor
public class DeathReportController {

    private final DeathReportService deathReportService;

    @PostMapping("/{serialNumber}")
    public BirthDeathReportResident registerDeathReport(@RequestBody DeathReportDto deathReportDto,
                                                        @PathVariable Integer serialNumber) {
        return deathReportService.createDeathReport(deathReportDto, serialNumber);
    }

    @PutMapping("/{serialNumber}/{targetSerialNumber}")
    public Integer editDeathReport(@RequestBody DeathReportDto deathReportDto,
                                   @PathVariable Integer serialNumber,
                                   @PathVariable Integer targetSerialNumber) {
        return deathReportService.modifyDeathReport(deathReportDto, serialNumber,
            targetSerialNumber);
    }

    @DeleteMapping("/{serialNumber}/{targetSerialNumber}")
    public void eraseDeathReport(@PathVariable Integer serialNumber,
                                 @PathVariable Integer targetSerialNumber) {
        deathReportService.removeDeathReport(serialNumber, targetSerialNumber);
    }
}

