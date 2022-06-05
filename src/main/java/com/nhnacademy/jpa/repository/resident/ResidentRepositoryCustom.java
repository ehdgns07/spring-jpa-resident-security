package com.nhnacademy.jpa.repository.resident;

import com.nhnacademy.jpa.domain.ResidentDetailsVo;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResidentRepositoryCustom {

    ResidentDetailsVo findLoginInfo(String id);

    List<String> findEmails();
}
