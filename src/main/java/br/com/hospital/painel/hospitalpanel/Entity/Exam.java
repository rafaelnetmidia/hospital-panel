package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq")
    private Long idExam;

    @Column
    private Boolean isCompleted;

    @Column
    private String result;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime dtCreate;

    @ManyToOne
    @JoinColumn(name = "id_attendance", nullable = false)
    private Attendance attendance;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_exam_type", nullable = false)
    private ExamType examType;

    @ManyToOne
    @JoinColumn(name = "id_exam_situation", nullable = false)
    private ExamSituation examSituation;

    public Exam() {}
}
