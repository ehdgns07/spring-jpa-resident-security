package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyRelationshipServiceImpl implements FamilyRelationShipService{

    FamilyRelationshipRepository familyRelationshipRepository;

    @Override
    public FamilyRelationship registerRelationShip(FamilyRelationship familyRelationship, Integer serialNo) {
        return familyRelationshipRepository.insertFamilyRelationship();
    }
}
