package com.nhnacademy.jpa.entity.certificate.issue;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.nhnacademy.jpa.entity.resident.Resident;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "certificate_issue")
public class CertificateIssue {

    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateConfirmNo;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    Resident resident;


    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private LocalDateTime certificateIssueDate;


}
