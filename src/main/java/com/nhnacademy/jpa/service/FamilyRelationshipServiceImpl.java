package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.ResidentRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FamilyRelationshipServiceImpl implements FamilyRelationShipService{
    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    @Override
    public FamilyRelationship registerRelationShip(FamilyRelationship familyRelationship, Integer serialNo) {
        Optional<Resident> baseResident = residentRepository.findById(serialNo);

        baseResident.ifPresent(familyRelationship::setBaseResidentSerialNo);

        return familyRelationshipRepository.save(familyRelationship);
    }
}
