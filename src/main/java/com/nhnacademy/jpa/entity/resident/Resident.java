package com.nhnacademy.jpa.entity.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resident")
public class Resident implements Persistable<Integer> {

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

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    // @Setter(AccessLevel.NONE)
    // @OrderColumn(name = "household_serial_number")
    // @OneToMany(mappedBy = "resident")
    // private List<Household> households = new ArrayList<>();
    //
    // @Setter(AccessLevel.NONE)
    // @OneToMany(mappedBy = "resident")
    // private List<CompositionResident> compositionResidents = new ArrayList<>();
    //
    // @Setter(AccessLevel.NONE)
    // @OneToMany(mappedBy = "baseResidentSerialNo")
    // private Set<FamilyRelationship> familyRelationships = new HashSet<>();
    //
    // public void addHousehold(Household household){
    //     household.setResident(this);
    //     households.add(household);
    // }
    //
    // public void addCompositionResident(CompositionResident compositionResident){
    //     compositionResident.setResident(this);
    //     compositionResidents.add(compositionResident);
    // }
    //
    // public void addFamilyRelationship(FamilyRelationship familyRelationship){
    //     familyRelationship.setBaseResidentSerialNo(this);
    //     familyRelationships.add(familyRelationship);
    //
    // }
}
