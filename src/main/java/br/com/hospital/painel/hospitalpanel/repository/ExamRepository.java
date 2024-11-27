package br.com.hospital.painel.hospitalpanel.repository;

import br.com.hospital.painel.hospitalpanel.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findAllByExamSituation_Status(Integer examSituation_status);
}