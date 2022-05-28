package com.nhnacademy.jpa.repository.birthDeath;

import com.nhnacademy.jpa.domain.BirthReportDto;
import com.nhnacademy.jpa.entity.birth.death.report.resident.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.birth.death.report.resident.QBirthDeathReportResident;
import com.nhnacademy.jpa.entity.resident.QResident;
import com.querydsl.jpa.impl.JPADeleteClause;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BirthRepositoryImpl extends QuerydslRepositorySupport implements BirthReportRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    public BirthRepositoryImpl() {
        super(BirthDeathReportResident.class);
    }


    @Override
    public void deleteById(Integer serialNumber, Integer targetSerialNumber) {

        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        JPADeleteClause deleteClause = new JPADeleteClause(em, birthDeathReportResident);

        deleteClause.where(birthDeathReportResident.pk.residentSerialNo.eq(serialNumber))
            .where(birthDeathReportResident.pk.reportResidentSerialNo.eq(targetSerialNumber))
            .execute();
    }
}
