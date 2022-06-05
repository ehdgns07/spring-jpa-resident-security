package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.domain.ResidentDetailsVo;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface ResidentService {
//rest api
    Resident createResident(Resident resident);
    Integer modifyResident(ResidentRegisterDto residentRegisterDto, Integer serialNo);
    Resident getResident(Integer serialNo);
//view

    Page<Resident> PagedResident(Pageable pageable);

    String tryToLoginAtGithub() throws URISyntaxException, NoSuchAlgorithmException;

    ResidentDetailsVo getOAuthEmail(String code, String state) throws URISyntaxException, IOException;

    boolean checkEmail(ResidentDetailsVo email, HttpServletRequest request,
                       HttpServletResponse response, Authentication authentication)
        throws ServletException, IOException;
}
