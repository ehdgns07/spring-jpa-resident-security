package com.nhnacademy.jpa.service.familyrelation;

import com.nhnacademy.jpa.domain.FamilyRelationShipDto;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;

public interface FamilyRelationShipService {
    FamilyRelationship registerRelationShip(FamilyRelationship familyRelationship, Integer serialNo);

    Integer modifyFamilyRelationship(FamilyRelationShipDto familyRelationShipDto, Integer serialNumber, Integer familySerialNumber);

    void removeFamilyRelationship(Integer serialNumber, Integer familySerialNumber);
}
