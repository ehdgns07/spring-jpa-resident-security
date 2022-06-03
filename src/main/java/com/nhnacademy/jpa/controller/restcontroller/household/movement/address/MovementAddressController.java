package com.nhnacademy.jpa.controller.restcontroller.household.movement.address;

import com.nhnacademy.jpa.domain.household.address.MovementAddressDto;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import com.nhnacademy.jpa.service.household.movement.address.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movement")
public class MovementAddressController {

	private final MovementService movementService;

	@PostMapping
	MovementAddress registerMovementAddress(@RequestBody MovementAddressDto movement){
		return movementService.createMovementAddress(movement);
	}

	@PutMapping
	Integer editMovementAddress(@RequestBody MovementAddressDto movementDto){
		return movementService.modifyMovementAddress(movementDto);
	}

	@DeleteMapping("/{householdSerialNo}/{reportDate}")
	void eraseMovementAddress(@PathVariable Integer householdSerialNo, @PathVariable String reportDate){
		movementService.removeMovementAddress(householdSerialNo, reportDate);
	}

}
