package com.nhnacademy.jpa.repository.resident;

import com.nhnacademy.jpa.domain.UserDetailsVo;
import com.nhnacademy.jpa.domain.resident.MemberDto;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.UserDetails;

@NoRepositoryBean
public interface ResidentRepositoryCustom {

    UserDetailsVo findLoginInfo(String id);
}
