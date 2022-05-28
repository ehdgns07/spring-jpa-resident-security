package com.nhnacademy.jpa.entity.family.relationship;

import com.nhnacademy.jpa.entity.resident.Resident;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.loader.plan.spi.Fetch;
import org.hibernate.mapping.FetchProfile;

@Getter
@Setter
@Entity
@Table(name = "family_relationship")
@NoArgsConstructor
@IdClass(FamilyRelationship.FrPk.class)
public class FamilyRelationship {

    //resident를 직접 매핑해야 하나?
    @Id
    @Column(name = "family_resident_serial_number")
    private Integer familyResidentSerialNo;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResidentSerialNo;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FrPk implements Serializable {

        private Integer familyResidentSerialNo;

        private Integer baseResidentSerialNo;
    }
}
