package com.nhnacademy.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthReportModifyDto {
    Integer ResidentSerialNo;

    Integer ReportResidentSerialNo;

    String EmailAddress;

    String PhoneNumber;

}
