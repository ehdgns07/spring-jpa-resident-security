package com.nhnacademy.jpa.entity.household;

import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import com.nhnacademy.jpa.entity.household.movement.address.MovementAddress;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_number")
    Integer householdSerialNo;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    Resident resident;

    @Column(name = "household_composition_date")
    LocalDate compositionDate;

    @Column(name = "household_composition_reason_code")
    String compositionReasonCode;

    @Column(name = "current_house_movement_address")
    String currentAddress;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "household", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<MovementAddress> movementAddresses;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "household", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<CompositionResident> compositionResidents;

    public void addCompositionResidents(CompositionResident compositionResident){
        compositionResident.setHousehold(this);
        compositionResidents.add(compositionResident);
    }

    public void addMovementAddress(MovementAddress movementAddress){
        movementAddress.setHousehold(this);
        movementAddresses.add(movementAddress);
    }

}
