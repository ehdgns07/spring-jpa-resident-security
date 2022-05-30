package com.nhnacademy.jpa.domain;

import lombok.Data;

@Data
public class DeathReportModifyDto {
    String emailAddress;

    String phoneNumber;

    String deathReportQualificationsCode;
}
