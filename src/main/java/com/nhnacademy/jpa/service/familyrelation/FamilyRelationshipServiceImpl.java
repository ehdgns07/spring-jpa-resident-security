package com.nhnacademy.jpa.service.familyrelation;

import com.nhnacademy.jpa.domain.FamilyRelationShipDto;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.familyrelationship.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
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

    @Override
    public Integer modifyFamilyRelationship(FamilyRelationShipDto familyRelationShipDto,
                                            Integer serialNumber, Integer familySerialNumber) {
        return familyRelationshipRepository.updateResident( familyRelationShipDto.getFamilyRelationshipCode(), familySerialNumber, serialNumber);
    }

    @Override
    public void removeFamilyRelationship(Integer serialNumber, Integer familySerialNumber) {
        FamilyRelationship.FrPk frPk = new FamilyRelationship.FrPk();
        frPk.setBaseResidentSerialNo(serialNumber);
        frPk.setFamilyResidentSerialNo(familySerialNumber);

        familyRelationshipRepository.deleteById(frPk);
    }
}
