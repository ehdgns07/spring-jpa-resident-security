package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.domain.resttemplate.ResidentVo;
import com.nhnacademy.jpa.domain.resttemplate.TokenInformation;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.resident.PagingResidentRepository;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import com.nhnacademy.jpa.service.CustomUserDetailsService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final PagingResidentRepository pagingResidentRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
    private final RestTemplate restTemplate;
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public Resident createResident(Resident resident) {
        resident.setPassword(passwordEncoder.encode(resident.getPassword()));

        return residentRepository.save(resident);
    }

    @Override
    public Integer modifyResident(ResidentRegisterDto residentRegisterDto, Integer serialNo) {
        // residentRepository.findById(serialNo)
        //                       .ifPresent(value -> {
        //                           value.set
        //                           residentRepository.save(value)
        //                       });
        return residentRepository.updateResident(residentRegisterDto.getName(),
            residentRegisterDto.getGender(), residentRegisterDto.getBirthDate(),
            residentRegisterDto.getBaseAddress(), serialNo);
    }

    @Override
    public Resident getResident(Integer serialNo) {
        Optional<Resident> residentOptional = residentRepository.findById(serialNo);
        if (residentOptional.isPresent()) {
            return residentOptional.get();
        }
        return null;
    }

    @Override
    public Page<Resident> PagedResident(Pageable pageable) {

        return pagingResidentRepository.findAll(pageable);
    }

    @Override
    public String tryToLoginAtGithub() throws URISyntaxException, NoSuchAlgorithmException {
        UriComponents uriComponents;
        URI uri = new URI("https://github.com/login/oauth/authorize");
        SecureRandom random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();
        Long randomLong;

        for (int i = 0; i < 10; i++) {
            randomLong = random.nextLong();
            sb.append(randomLong);
        }

        uriComponents = UriComponentsBuilder.newInstance()
                                            .scheme("https")
                                            .host("github.com")
                                            .path("/login/oauth/authorize")
                                            .queryParam("client_id", "e3552959b3a52b993c48")
                                            .queryParam("redirect_url",
                                                "localhost:8080/residents/index?page=0&size=5")
                                            .queryParam("scope", "user:email")
                                            .queryParam("state", sb.toString()).build();

        return uriComponents.toString();
    }

    @Override
    public ResidentVo getOAuthEmail(String code, String state) throws URISyntaxException, IOException {

        UriComponents uri = UriComponentsBuilder.newInstance()
                                                .scheme("https")
                                                .host("github.com")
                                                .path("/login/oauth/access_token")
                                                .queryParam("client_id","e3552959b3a52b993c48")
                                                .queryParam("client_secret",
                                                    "760619bd131104fd1155380037600ed5b3671a40")
                                                .queryParam("code", code)
                                                .queryParam("redirect_url",
                                                    "localhost:8080/residents/index?page=0&size=5")
                                                    .build();

        TokenInformation tokeninformation = restTemplate.getForObject(uri.toUri(), TokenInformation.class);

        ResidentVo residentVo = getOAuthEmail(tokeninformation);

        return residentVo;
    }

    @Override
    public boolean checkEmail(ResidentVo residentVo, HttpServletRequest request,
                              HttpServletResponse response,
                              Authentication authentication) throws ServletException, IOException {
        List<Resident> residents = residentRepository.findAll();

        //github에서 user 정보를 가져오는 것은 성공 했으나 email 부분을 null을 받아와서 임의로 지정.
        residentVo.setEmail("ehdgns07@gmail.com");

        for (Resident resident : residents) {
            if(Objects.equals(residentVo.getEmail(), resident.getEmail())){

                residentVo.setAuthority(resident.getAuthority());
                List<GrantedAuthority> authorities = new ArrayList<>(residentVo.getAuthorities());

                HttpSession session = request.getSession(false);

                redisTemplate.opsForHash().put(session.getId(), "username", residentVo.getUsername());
                redisTemplate.opsForHash().put(session.getId(), "authority", authorities.get(0).getAuthority());

                session.setAttribute("username", residentVo.getUsername());
                session.setAttribute("authority", authorities.get(0).getAuthority());

                log.debug("loginSuccess---------------------------------");
                return true;
            }
        }

        return false;
    }

    private ResidentVo getOAuthEmail(TokenInformation tokeninformation) {
        UriComponents uri;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "token "+ tokeninformation.getAccess_token());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("api.github.com")
            .path("user")
            .queryParam("username","ehdgns07")
            .build();

        ResponseEntity<ResidentVo>
            residentVo = restTemplate.exchange(uri.toUri(), HttpMethod.GET, httpEntity, ResidentVo.class);

        return residentVo.getBody();
    }


}
