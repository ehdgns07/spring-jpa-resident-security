package com.nhnacademy.jpa.service.household.movement.address;

import com.nhnacademy.jpa.domain.household.address.MovementAddressDto;
import com.nhnacademy.jpa.domain.household.address.MovementReportDateOnly;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import com.nhnacademy.jpa.repository.household.HouseholdRepository;
import com.nhnacademy.jpa.repository.household.movement.address.MovementAddressRepository;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService{

	private final MovementAddressRepository movementAddressRepository;
	private final HouseholdRepository householdRepository;

	@Override
	@Transactional
	public MovementAddress createMovementAddress(MovementAddressDto movement) {

		List<MovementReportDateOnly> pastAddress = movementAddressRepository.findAll(
			movement.getHousehold());

		movementAddressRepository.updatePastAddress(movement.getHousehold(), pastAddress.get(pastAddress.size()-1).getMovementReportDate());

		Optional<Household> optionalHousehold = householdRepository.findById(movement.getHousehold());

		Household household = optionalHousehold.orElse(null);

		// MovementAddress.MovementPk pk = new MovementAddress.MovementPk();
		// pk.setHousehold(movement.getHousehold());
		// pk.setMovementReportDate(movement.getMovementReportDate());

		MovementAddress movementAddress = MovementAddress.builder()
			.movementReportDate(movement.getMovementReportDate())
			.isLastAddress("y")
			.houseMovementAddress(movement.getHouseMovementAddress())
			.household(household)
			.build();

		return movementAddressRepository.save(movementAddress);
		}

	@Override
	public Integer modifyMovementAddress(MovementAddressDto movementDto) {

		return movementAddressRepository.updateCurrentAddress(movementDto.getHouseMovementAddress(), movementDto.getHousehold(), movementDto.getMovementReportDate());
	}

	@Override
	public void removeMovementAddress(Integer householdSerialNo, String reportDate) {
		MovementAddress.MovementPk pk = new MovementAddress.MovementPk();

		LocalDate MovementReportDate = LocalDate.parse(reportDate);
		pk.setMovementReportDate(MovementReportDate);
		pk.setHousehold(householdSerialNo);

		movementAddressRepository.deleteById(pk);
	}


}
