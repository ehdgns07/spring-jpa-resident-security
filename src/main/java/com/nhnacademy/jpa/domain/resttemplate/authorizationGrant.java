package com.nhnacademy.jpa.domain.resttemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class authorizationGrant {

    String code;

    String state;
}
