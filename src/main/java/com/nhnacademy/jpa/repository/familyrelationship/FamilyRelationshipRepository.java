package com.nhnacademy.jpa.repository.familyrelationship;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRelationshipRepository extends
    JpaRepository<FamilyRelationship, FamilyRelationship.FrPk>, FamilyRelationshipCustom {

    @Transactional
    @Modifying
    @Query(value = "UPDATE family_relationship set family_relationship_code = ?1 WHERE family_resident_serial_number = ?2 and base_resident_serial_number = ?3", nativeQuery = true)
    Integer updateResident( String relationshipCode, Integer familyResidentSerialNo, Integer baseResidentSerialNo );
}
