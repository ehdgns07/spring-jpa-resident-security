package com.nhnacademy.jpa.repository.familyrelationship;

import com.nhnacademy.jpa.controller.familyrelationship.FamilyRelationship;
import com.nhnacademy.jpa.domain.familyrelationship.FamilyRelationshipCertificationDto;
import com.nhnacademy.jpa.entity.family.relationship.QFamilyRelationship;
import com.nhnacademy.jpa.entity.resident.QResident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationshipCertificationDto> findCertification() {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident resident = QResident.resident;

        return from(familyRelationship)
            .innerJoin(familyRelationship.baseResidentSerialNo, resident)
            .where(familyRelationship.baseResidentSerialNo.residentSerialNo.eq(resident.residentSerialNo))
            .select(Projections.bean(FamilyRelationshipCertificationDto.class, familyRelationship.familyResidentSerialNo,
                familyRelationship.baseResidentSerialNo, resident.name, resident.birthDate, resident.gender))
            .fetch();

    }
}
