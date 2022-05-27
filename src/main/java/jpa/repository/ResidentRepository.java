package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE resident set name = ?1, gender_code = ?2,registration_base_address = ?3, registration_base_address = ?4 WHERE resident_serial_number = ?5", nativeQuery = true)
    Integer updateResident(String name, String gender, LocalDateTime birthDate, String address, Integer serialNo );
}
