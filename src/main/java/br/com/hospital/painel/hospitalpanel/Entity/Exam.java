package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq")
    private Long idExam;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_attendance")
    private Attendance attendance;

    @Column
    private Boolean isCompleted;

    @Column
    private String result;

    public Exam() {}
}
