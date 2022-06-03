package com.nhnacademy.jpa.domain.resident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    String username;

    String password;

    String email;

    String authority;
}
