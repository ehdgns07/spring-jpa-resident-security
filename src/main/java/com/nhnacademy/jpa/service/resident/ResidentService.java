package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.resident.Resident;

public interface ResidentService {

    Resident createResident(Resident resident);
    Integer editResident(ResidentRegisterDto residentRegisterDto, Integer serialNo);

}
