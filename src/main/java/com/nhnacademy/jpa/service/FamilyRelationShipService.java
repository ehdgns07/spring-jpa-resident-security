package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;

public interface FamilyRelationShipService {
    FamilyRelationship registerRelationShip(FamilyRelationship familyRelationship, Integer serialNo);

}
