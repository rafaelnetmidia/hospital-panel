package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_seq")
    private Long idAttendance;
    @CreationTimestamp
    private Date dtStartAttendance;
    @UpdateTimestamp
    private Date dtUpdateAttendance;
    private Date dtEndAttendance;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "id_attendance_type")
    private AttendanceType attendanceType;


    @ManyToOne
    @JoinColumn(name = "id_attendance_situation")
    private AttendanceSituation attendanceSituation;


    public Attendance() {

    }
}
