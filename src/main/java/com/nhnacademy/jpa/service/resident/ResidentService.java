package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.resident.Resident;

public interface ResidentService {

    Resident createResident(Resident resident);
    Integer modifyResident(ResidentRegisterDto residentRegisterDto, Integer serialNo);
    Resident getResident(Integer serialNo);

}
