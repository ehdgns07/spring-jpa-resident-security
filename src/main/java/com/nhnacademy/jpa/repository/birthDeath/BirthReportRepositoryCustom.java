package com.nhnacademy.jpa.repository.birthDeath;

import com.nhnacademy.jpa.domain.BirthReportDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthReportRepositoryCustom {
    void deleteById(Integer serialNumber, Integer targetSerialNumber);
}
