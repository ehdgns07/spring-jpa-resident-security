package com.nhnacademy.jpa.repository.resident;


import com.nhnacademy.jpa.domain.ResidentDetailsVo;
import com.nhnacademy.jpa.entity.resident.QResident;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ResidentRepositoryImpl extends QuerydslRepositorySupport implements ResidentRepositoryCustom{

    public ResidentRepositoryImpl() {
        super(Resident.class);
    }

    @Override
    public ResidentDetailsVo findLoginInfo(String id) {
        QResident resident = QResident.resident;

        return from(resident)
            .select(Projections.bean(ResidentDetailsVo.class, resident.username, resident.password, resident.email ,resident.authority ))
            .where(resident.username.eq(id))
            .fetchOne();
    }

    @Override
    public List<String> findEmails() {
        QResident resident = QResident.resident;

        return from(resident)
            .select(resident.email)
            .fetch();
    }
}
