package com.nhnacademy.jpa.service.household;

import com.nhnacademy.jpa.domain.household.HouseholdDto;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.resident.Resident;

public interface HouseholdService {
    Household createHousehold(HouseholdDto householdDto, Resident resident);

    void removeHousehold(Integer serialNo);
}
