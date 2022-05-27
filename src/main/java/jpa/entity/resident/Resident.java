package com.nhnacademy.jpa.entity.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resident")
public class Resident {

    @Id
    @Column(name = "resident_serial_number")
    Integer residentSerialNo;

    String name;

    @Column(name = "resident_registration_number")
    String registrationNo;

    @Column(name = "gender_code")
    String gender;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss")
    @Column(name = "birth_date")
    LocalDateTime birthDate;

    @Column(name = "birth_place_code")
    String birthPlace;

    @Column(name = "registration_base_address")
    String baseAddress;

    @Column(name = "death_date")
    LocalDateTime deathDate;

    @Column(name = "death_place_code")
    String deathPlaceCode;

    @Column(name = "death_place_address")
    String deathPlaceAddress;

    @OneToMany(mappedBy = "houseHoldSerialNo")
    private List<Household> households;

    @OneToMany(mappedBy = "resident")
    private List<CompositionResident> compositionResidents;

    @OneToMany(mappedBy = "baseResidentSerialNo")
    private List<FamilyRelationship> familyRelationships;
}
