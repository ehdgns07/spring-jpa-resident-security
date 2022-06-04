package com.nhnacademy.jpa.service.resident;

import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.repository.resident.PagingResidentRepository;
import com.nhnacademy.jpa.repository.resident.ResidentRepository;
import com.nhnacademy.jpa.service.CustomUserDetailsService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService{

    private final ResidentRepository residentRepository;
    private final PagingResidentRepository pagingResidentRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
    private final RestTemplate restTemplate;

    @Override
    public Resident createResident(Resident resident){
        resident.setPassword(passwordEncoder.encode(resident.getPassword()));

        return residentRepository.save(resident);
    }

    @Override
    public Integer modifyResident(ResidentRegisterDto residentRegisterDto, Integer serialNo){
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
        if(residentOptional.isPresent()) {
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

        for(int i = 0; i<10; i++) {
            randomLong = random.nextLong();
            sb.append(randomLong);
        }

        uriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("github.com")
            .path("/login/oauth/authorize")
            .queryParam("client_id", "e3552959b3a52b993c48")
            .queryParam("redirect_url","localhost:8080/residents/index?page=0&size=5")
            .queryParam("scope", "read:user")
            .queryParam("state", sb.toString()).build();

        // uri = new URIBuilder(uri).addParameter("client_id", "e3552959b3a52b993c48")
        //     .addParameter("redirect_url","localhost:8080/residents/index?page=0&size=5")
        //     .addParameter("scope", "read:user")
        //     .addParameter("state", sb.toString())
        //     .build();

        restTemplate.getForObject(uriComponents.toUri(),)
        log.debug("{}", uri.toString());

        return uriComponents.toString();
    }

    @Override
    public String getAccessToken(String code, String state) throws URISyntaxException, IOException {

        URI uri = new URI("https://github.com/login/oauth/access_token");

        uri = new URIBuilder(uri)
            .addParameter("client_id","e3552959b3a52b993c48")
            .addParameter("client_secret", "760619bd131104fd1155380037600ed5b3671a40")
            .addParameter("code", code)
            .addParameter("redirect_url", "localhost:8080/residents/index?page=0&size=5").build();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(new HttpPost(uri));


        return uri.toString();
    }


}
