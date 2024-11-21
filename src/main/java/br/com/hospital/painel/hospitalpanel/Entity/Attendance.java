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

    @Column(length = 500)
    private String remarks;

    @Column
    private String currentLocation;

    @Column
    private String estimatedCompletionTime;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_attendance_situation", nullable = false)
    private AttendanceSituation attendanceSituation;

    public Attendance() {

    }
}
