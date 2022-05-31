package com.nhnacademy.jpa.repository.household.movement.address;

import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementAddressRepository extends JpaRepository<MovementAddress, MovementAddress.MovementPk> {
}
