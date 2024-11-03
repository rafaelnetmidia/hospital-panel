package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AttendanceType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_type_seq")
    private Long idAttendanceType;
    private String type;
    private Integer status;

    public AttendanceType() {

    }
}
