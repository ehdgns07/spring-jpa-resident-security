package com.nhnacademy.jpa.entity.household.movement.address;


import com.nhnacademy.jpa.entity.household.Household;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "household_movment_address")
@IdClass(MovementAddress.MovementPk.class)
public class MovementAddress {

    @Id
    @Column(name = "house_movement_report_date")
    LocalDate movementReportDate;

    @Id
    @ManyToOne
    @JoinColumn(name = "household_serial_no")
    Household householdSerialNo;

    @Column(name = "house_movement_address")
    String houseMovementAddress;

    @Column(name = "last_address_yn")
    String isLastAddress;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MovementPk implements Serializable {

        @Column(name = "house_movement_report_date")
        private LocalDate movementReportDate;

        @Column(name = "household_serial_number")
        private Integer householdSerialNo;
    }

}
