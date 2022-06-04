package com.nhnacademy.jpa.controller.resident;

import com.nhnacademy.jpa.domain.resident.MemberDto;
import com.nhnacademy.jpa.service.resident.ResidentService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    void getToken(@RequestParam String code, @RequestParam String state)
        throws URISyntaxException, IOException {
        residentService.getAccessToken(code, state);
    }
/*
    @PostMapping
    String attemptLogin(@RequestParam String id, @RequestParam String pwd, HttpServletRequest request){
         return residentService.doLogin(id, pwd, request);
    }
*/
}
