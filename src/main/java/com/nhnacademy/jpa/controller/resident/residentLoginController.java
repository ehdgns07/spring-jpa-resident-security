package com.nhnacademy.jpa.controller.resident;

import com.nhnacademy.jpa.domain.ResidentDetailsVo;
import com.nhnacademy.jpa.service.resident.ResidentService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class residentLoginController {
    private final ResidentService residentService;

    @GetMapping
    String loginForm(){
        return "resident/login";
    }

    @GetMapping("/github")
    void LoginToGithub(HttpServletResponse response)
        throws URISyntaxException, IOException, NoSuchAlgorithmException {
        response.sendRedirect(residentService.tryToLoginAtGithub());
    }

    @GetMapping("/oauth2/code/github")
    String doLogin(@RequestParam String code, @RequestParam String state, HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws URISyntaxException, IOException, ServletException {
        ResidentDetailsVo residentDetailsVo = residentService.getOAuthEmail(code, state);
        if(!residentService.checkEmail(residentDetailsVo, request, response, authentication)){
            return "redirect:resident/login";
        }

        return null;
    }
/*
    @PostMapping
    String attemptLogin(@RequestParam String id, @RequestParam String pwd, HttpServletRequest request){
         return residentService.doLogin(id, pwd, request);
    }
*/
}
