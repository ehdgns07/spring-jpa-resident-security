package com.nhnacademy.jpa.repository.resident;


import com.nhnacademy.jpa.domain.UserDetailsVo;
import com.nhnacademy.jpa.domain.resident.MemberDto;
import com.nhnacademy.jpa.entity.resident.QResident;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.security.core.userdetails.UserDetails;

public class ResidentRepositoryImpl extends QuerydslRepositorySupport implements ResidentRepositoryCustom{

    public ResidentRepositoryImpl() {
        super(Resident.class);
    }

    @Override
    public UserDetailsVo findLoginInfo(String id) {
        QResident resident = QResident.resident;

        return from(resident)
            .select(Projections.bean(UserDetailsVo.class, resident.username, resident.password, resident.email ,resident.authority ))
            .where(resident.username.eq(id))
            .fetchOne();
    }
}
