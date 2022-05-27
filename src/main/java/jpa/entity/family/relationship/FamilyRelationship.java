package com.nhnacademy.jpa.entity.family.relationship;

import com.nhnacademy.jpa.entity.resident.Resident;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "family_relationship")
@IdClass(FamilyRelationship.FrPk.class)
public class FamilyRelationship {

    @Id
    @Column(name = "family_resident_serial_number")
    private Integer familyResidentSerialNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResidentSerialNo;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class FrPk implements Serializable {

        private Integer familyResidentSerialNo;

        private Integer baseResidentSerialNo;
    }
}
