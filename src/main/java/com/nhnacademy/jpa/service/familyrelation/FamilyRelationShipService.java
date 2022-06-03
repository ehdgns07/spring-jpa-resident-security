package com.nhnacademy.jpa.service.familyrelation;

import com.nhnacademy.jpa.domain.FamilyRelationShipDto;
import com.nhnacademy.jpa.domain.familyrelationship.FamilyRelationshipCertificationDto;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import java.util.List;

public interface FamilyRelationShipService {
    FamilyRelationship registerRelationShip(FamilyRelationship familyRelationship, Integer serialNo);

    Integer modifyFamilyRelationship(FamilyRelationShipDto familyRelationShipDto, Integer serialNumber, Integer familySerialNumber);

    void removeFamilyRelationship(Integer serialNumber, Integer familySerialNumber);

    List<FamilyRelationshipCertificationDto> doCertificate(Integer baseResidentSerialNo);
}
