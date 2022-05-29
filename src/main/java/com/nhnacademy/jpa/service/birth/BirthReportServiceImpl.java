package com.nhnacademy.jpa.service.birth;

import com.nhnacademy.jpa.domain.BirthReportDto;
import com.nhnacademy.jpa.domain.BirthReportModifyDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.birthDeath.BirthDeathReportRepository;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BirthReportServiceImpl implements BirthReportService{

    private final ResidentRepository residentRepository;
    private final BirthDeathReportRepository birthDeathReportRepository;

    @Override
    public BirthDeathReportResident createBirthReport(BirthReportDto birthReportDto, Integer serialNumber) {
        Optional<Resident> resident = residentRepository.findById(birthReportDto.getResidentSerialNo());
        Resident birthResident = new Resident();

        if(resident.isPresent()){
            birthResident = resident.get();
        }

        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(birthReportDto.getResidentSerialNo(), birthReportDto.getBirthDeathCode(), serialNumber);

        BirthDeathReportResident birthDeathReportResident =
            new BirthDeathReportResident(pk, birthResident, birthReportDto.getReportDate(),
                                        birthReportDto.getBirthReportQualificationsCode(), birthReportDto.getEmailAddress(), birthReportDto.getPhoneNumber());

        return birthDeathReportRepository.save(birthDeathReportResident);
    }

    @Override
    public Integer modifyBirthReport(BirthReportModifyDto birthReportModifyDto,
                                     Integer serialNumber, Integer targetSerialNumber) {

        return birthDeathReportRepository.updateBirthReport(birthReportModifyDto.getEmailAddress(), birthReportModifyDto.getPhoneNumber(), serialNumber, targetSerialNumber);
    }

    @Override
    public void removeBirthReport(Integer serialNumber, Integer targetSerialNumber) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk();
        pk.setReportResidentSerialNo(serialNumber);
        pk.setResidentSerialNo(targetSerialNumber);
        pk.setBirthDeathCode("출생");

        birthDeathReportRepository.deleteById(pk);
    }
}
