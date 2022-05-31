package com.nhnacademy.jpa.entity.household.composition.resident;

import com.nhnacademy.jpa.entity.household.Household;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "household_composition_resident")
@Builder
public class CompositionResident {

    @EmbeddedId
    private CompositionPk compositionPk;

    @MapsId("residentSerialNo")
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @MapsId("householdSerialNo")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "report_date")
    LocalDate reportDate;

    @Column(name = "household_relationship_code")
    String relationshipCode;

    @Column(name = "household_composition_change_reason_code")
    String compositionChangeReasonCode;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class CompositionPk implements Serializable {

        Integer householdSerialNo;

        Integer residentSerialNo;
    }

}
