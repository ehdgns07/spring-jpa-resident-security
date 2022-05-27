package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends
    JpaRepository<FamilyRelationship, FamilyRelationship.FrPk> {
}
