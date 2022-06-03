package com.nhnacademy.jpa.repository.familyrelationship;

import com.nhnacademy.jpa.domain.familyrelationship.FamilyRelationshipCertificationDto;
import java.util.List;

public interface FamilyRelationshipCustom {

    List<FamilyRelationshipCertificationDto> findCertification();
}
