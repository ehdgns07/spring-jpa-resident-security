package com.nhnacademy.jpa.domain.familyrelationship;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipCertificationDto {
    Integer familyResidentSerialNo;

    Integer baseResidentSerialNo;

    String familyRelationshipCode;

    String name;

    LocalDate birthDate;

    String gender;

}
