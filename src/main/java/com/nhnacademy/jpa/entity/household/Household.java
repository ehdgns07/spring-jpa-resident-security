package com.nhnacademy.jpa.entity.household;

import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_no")
    Integer houseHoldSerialNo;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    Resident resident;

    @Column(name = "household_composition_date")
    LocalDateTime compositionDate;

    @Column(name = "household_composition_reason_code")
    String compositionReasonCode;

    @Column(name = "current_house_movement_address")
    String currentAddress;

    @OneToMany(mappedBy = "householdSerialNo")
    List<MovementAddress> movementAddresses;

    @OneToMany(mappedBy = "household")
    List<CompositionResident> compositionResidents;

}
