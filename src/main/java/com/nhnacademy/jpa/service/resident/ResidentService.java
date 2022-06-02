package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {
//rest api
    Resident createResident(Resident resident);
    Integer modifyResident(ResidentRegisterDto residentRegisterDto, Integer serialNo);
    Resident getResident(Integer serialNo);
//view

    Page<Resident> PagedResident(Pageable pageable);
}
