package com.nhnacademy.jpa.repository.resident;

import com.nhnacademy.jpa.entity.resident.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingResidentRepository extends PagingAndSortingRepository<Resident, Integer> {

    Page<Resident> findAll(Pageable pageable);
}
