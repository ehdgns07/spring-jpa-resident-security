package com.nhnacademy.jpa.service.household;

import com.nhnacademy.jpa.domain.household.HouseholdDto;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.household.HouseholdRepository;
import com.nhnacademy.jpa.repository.household.composition.resident.CompositionResidentRepository;
import com.nhnacademy.jpa.repository.household.movement.address.MovementAddressRepository;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseholdServiceImpl implements HouseholdService{

    private final HouseholdRepository householdRepository;
    private final CompositionResidentRepository compositionResidentRepository;
    private final MovementAddressRepository movementAddressRepository;

    @Override
    @Transactional
    public Household createHousehold(HouseholdDto householdDto, Resident resident) {

        Household household = buildHousehold(householdDto);

        CompositionResident compositionResident =
            buildCompositionResident(householdDto, resident.getResidentSerialNo(), resident);
        household.addCompositionResidents(compositionResident);

        compositionResidentRepository.save(compositionResident);

        MovementAddress movementAddress =
            buildMovementAddress(householdDto);
        household.addMovementAddress(movementAddress);

        movementAddressRepository.save(movementAddress);

        household.setResident(resident);

        return householdRepository.save(household);
    }

    @Override
    public void removeHousehold(Integer serialNo) {
        householdRepository.deleteById(serialNo);
    }


    private Household buildHousehold(HouseholdDto householdDto) {
        return Household.builder()
                        .householdSerialNo(householdDto.getHouseholdSerialNo())
                        .compositionDate(householdDto.getCompositionDate())
                        .compositionReasonCode(householdDto.getCompositionReasonCode())
                        .currentAddress(householdDto.getCurrentAddress())
                        .compositionResidents(new ArrayList<>())
                        .movementAddresses(new HashSet<>())
                        .build();
    }

    private MovementAddress buildMovementAddress(HouseholdDto householdDto) {
        MovementAddress.MovementPk pk = new MovementAddress.MovementPk();
        pk.setHousehold(householdDto.getHouseholdSerialNo());
        pk.setMovementReportDate(householdDto.getCompositionDate());

        return MovementAddress.builder()
                              .movementReportDate(householdDto.getCompositionDate())
                              .houseMovementAddress(householdDto.getCurrentAddress())
                              .isLastAddress("y")
                              .build();
    }

    private CompositionResident buildCompositionResident(HouseholdDto householdDto,
                                                         Integer residentSerialNo,
                                                         Resident resident) {
        CompositionResident.CompositionPk compositionPk = new CompositionResident.CompositionPk();
        compositionPk.setHouseholdSerialNo(householdDto.getHouseholdSerialNo());
        compositionPk.setResidentSerialNo(residentSerialNo);

        return CompositionResident.builder()
                                  .compositionPk(compositionPk)
                                  .resident(resident)
                                  .reportDate(householdDto.getCompositionDate())
                                  .relationshipCode("세대주")
                                  .compositionChangeReasonCode("세대분리")
                                  .build();
    }
}
