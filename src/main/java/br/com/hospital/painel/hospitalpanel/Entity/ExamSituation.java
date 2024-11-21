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
public class ExamSituation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_situation_seq")
    private Long idExamSituation;
    private String situation;
    private Integer status;

    public ExamSituation() {

    }
}
