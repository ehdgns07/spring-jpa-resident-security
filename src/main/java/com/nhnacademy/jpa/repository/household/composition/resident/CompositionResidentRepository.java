package com.nhnacademy.jpa.repository.household.composition.resident;

import com.nhnacademy.jpa.entity.household.composition.resident.CompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionResidentRepository extends JpaRepository<CompositionResident, CompositionResident.CompositionPk> {
}
