package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    FamilyRelationship insertFamilyRelationship();
}
