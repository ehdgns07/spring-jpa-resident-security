package com.nhnacademy.jpa.domain.resident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentVo {
	String name;

	String username;

	String password;

	String email;

	String authority;
}
