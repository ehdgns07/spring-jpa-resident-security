package com.nhnacademy.jpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.orm.jpa.JpaVendorAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthReportDto {

    String birthDeathCode;

    Integer residentSerialNo;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    LocalDate reportDate;

    String birthReportQualificationsCode;

    String emailAddress;

    String phoneNumber;


}
