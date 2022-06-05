package com.nhnacademy.jpa.repository.resident;

import com.nhnacademy.jpa.domain.resttemplate.ResidentVo;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResidentRepositoryCustom {

    ResidentVo findLoginInfo(String id);

    List<String> findEmails();
}
