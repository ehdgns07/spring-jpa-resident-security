package com.nhnacademy.jpa.service.household.movement.address;

import com.nhnacademy.jpa.domain.household.address.MovementAddressDto;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import java.time.LocalDate;

public interface MovementService {
	MovementAddress createMovementAddress(MovementAddressDto movement);

	Integer modifyMovementAddress(MovementAddressDto movementDto);

    void removeMovementAddress(Integer householdSerialNo, String reportDate);
}
