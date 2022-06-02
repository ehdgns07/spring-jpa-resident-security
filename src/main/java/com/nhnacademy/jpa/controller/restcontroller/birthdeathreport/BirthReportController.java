package com.nhnacademy.jpa.controller.restcontroller.birthdeathreport;

import com.nhnacademy.jpa.domain.BirthReportDto;
import com.nhnacademy.jpa.domain.BirthReportModifyDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import com.nhnacademy.jpa.service.birth.BirthReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/birth")
public class BirthReportController {

    private final BirthReportService birthReportService;

    @PostMapping("/{serialNumber}")
    public BirthDeathReportResident registerBirthReport(@RequestBody
                                                            BirthReportDto birthReportDto,
                                                        @PathVariable Integer serialNumber){
        return birthReportService.createBirthReport(birthReportDto, serialNumber);
    }

    @PutMapping("/{serialNumber}/{targetSerialNumber}")
    public Integer editBirthReport(@PathVariable Integer serialNumber, @PathVariable Integer targetSerialNumber,
                                   @RequestBody BirthReportModifyDto birthReportModifyDto){

        return birthReportService.modifyBirthReport(birthReportModifyDto, serialNumber, targetSerialNumber);

    }

    @DeleteMapping("/{serialNumber}/{targetSerialNumber}")
    public void eraseBirthReport(@PathVariable Integer serialNumber, @PathVariable Integer targetSerialNumber){
        birthReportService.removeBirthReport(serialNumber,targetSerialNumber);
    }
}
