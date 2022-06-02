package com.nhnacademy.jpa.restcontroller.household;


import com.nhnacademy.jpa.domain.household.HouseholdDto;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.service.household.HouseholdService;
import com.nhnacademy.jpa.service.resident.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/household")
public class HouseholdController {

    private final HouseholdService householdService;
    private final ResidentService residentService;

    @PostMapping
    public Household registerHousehold(@RequestBody HouseholdDto householdDto){
        Resident resident = residentService.getResident(householdDto.getHouseholdResidentSerialNo());
        return householdService.createHousehold(householdDto, resident);

    }

    @DeleteMapping("/{serialNo}")
    public void eraseHousehold(@PathVariable Integer serialNo){

        householdService.removeHousehold(serialNo);
    }
}
