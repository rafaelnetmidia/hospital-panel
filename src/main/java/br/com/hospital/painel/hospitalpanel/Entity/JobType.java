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
@AllArgsConstructor
@Builder
public class JobType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobtype_seq")
    private Long idJobType;
    private String position;
    private String status;

    public JobType() {

    }
}
