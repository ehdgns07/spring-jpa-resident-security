package com.nhnacademy.jpa.repository.household;

import com.nhnacademy.jpa.domain.household.HouseholdDto;
import com.nhnacademy.jpa.entity.household.Household;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {

    @Query("delete from Household where resident.residentSerialNo = 0")
    void deleteById(Integer serialNo);
}
