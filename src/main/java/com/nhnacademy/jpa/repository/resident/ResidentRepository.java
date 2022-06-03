package com.nhnacademy.jpa.repository.resident;

import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.security.core.userdetails.UserDetails;

public interface ResidentRepository extends JpaRepository<Resident, Integer>, ResidentRepositoryCustom{

    UserDetails findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE resident set name = ?1, gender_code = ?2,registration_base_address = ?3, registration_base_address = ?4 WHERE resident_serial_number = ?5", nativeQuery = true)
    Integer updateResident(String name, String gender, LocalDateTime birthDate, String address, Integer serialNo );
}
