package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom{

    public FamilyRelationRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public FamilyRelationship insertFamilyRelationship() {

        return null;
    }
}
