package com.nhnacademy.jpa.repository.household.movement.address;

import com.nhnacademy.jpa.domain.household.address.MovementAddressDto;
import com.nhnacademy.jpa.domain.household.address.MovementReportDateOnly;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovementAddressRepository extends JpaRepository<MovementAddress, MovementAddress.MovementPk> {

	@Query(value = "select house_movement_report_date from household_movement_address where household_serial_number = ?1", nativeQuery = true)
	List<MovementReportDateOnly> findAll(Integer householdSerialNo);

	@Transactional
	@Modifying
	@Query(value = "update household_movement_address set last_address_yn='n' where household_serial_number = ?1 and house_movement_report_date = ?2", nativeQuery = true)
	void updatePastAddress(Integer householdSerialNo, LocalDate lastAddressDate);

	@Transactional
	@Modifying
	@Query(value = "update MovementAddress set houseMovementAddress = ?1 where household.householdSerialNo = ?2 and movementReportDate = ?3")
	Integer updateCurrentAddress(String houseMovementAddress, Integer household, LocalDate movementReportDate);
}
