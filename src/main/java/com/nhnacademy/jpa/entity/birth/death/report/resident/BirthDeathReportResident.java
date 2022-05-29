package com.nhnacademy.jpa.entity.birth.death.report.resident;

import com.nhnacademy.jpa.entity.resident.Resident;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "birth_death_report_resident")
@Builder
public class BirthDeathReportResident implements Persistable<BirthDeathReportResident.Pk> {

    public BirthDeathReportResident(
        Pk pk, Resident resident, LocalDate reportDate, String birthReportQualificationsCode,
        String emailAddress, String phoneNumber) {
        this.pk = pk;
        this.resident = resident;
        this.reportDate = reportDate;
        this.birthReportQualificationsCode = birthReportQualificationsCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    @EmbeddedId
    private Pk pk;

    @MapsId("reportResidentSerialNo")
    @ManyToOne
    @JoinColumn(name = "report_resident_serial_number")
    private Resident resident;

    @Column(name = "birth_death_report_date")
    private LocalDate reportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Transient
    boolean shouldBeNew = false;

    @Override
    public Pk getId() {
        return pk;
    }

    @Override
    public boolean isNew() { return shouldBeNew || Objects.isNull(pk); }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {

        @Column(name = "resident_serial_number")
        private Integer residentSerialNo;

        @Column(name ="birth_death_type_code")
        private String birthDeathCode;

        private Integer reportResidentSerialNo;

    }

}
