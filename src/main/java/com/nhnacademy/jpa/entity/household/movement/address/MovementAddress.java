package com.nhnacademy.jpa.entity.household.movement.address;


import com.nhnacademy.jpa.entity.household.Household;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "household_movement_address")
@IdClass(MovementAddress.MovementPk.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementAddress {

    @Id
    @Column(name = "house_movement_report_date")
    LocalDate movementReportDate;

    @Id
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "household_serial_number")
    Household household;

    @Column(name = "house_movement_address")
    String houseMovementAddress;

    @Column(name = "last_address_yn")
    String isLastAddress;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MovementPk implements Serializable {

        private LocalDate movementReportDate;

        private Integer household;
    }

}
