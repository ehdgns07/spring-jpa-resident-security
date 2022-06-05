package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.ResidentDetailsVo;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ResidentRepository residentRepository;
    @Override
    public ResidentDetailsVo loadUserByUsername(String username) throws UsernameNotFoundException {

        return residentRepository.findLoginInfo(username);
    }
}
