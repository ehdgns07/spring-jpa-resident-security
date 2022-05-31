package com.nhnacademy.jpa.domain.death;

import lombok.Data;

@Data
public class DeathReportModifyDto {
    String emailAddress;

    String phoneNumber;

    String deathReportQualificationsCode;
}
