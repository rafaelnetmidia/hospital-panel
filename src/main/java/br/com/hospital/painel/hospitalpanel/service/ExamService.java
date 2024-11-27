package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.*;
import br.com.hospital.painel.hospitalpanel.repository.ExamRepository;
import br.com.hospital.painel.hospitalpanel.request.exam.UpdateExamRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Exam registerExam(Long idAttendance, Long idExamType, Long idEmployee) {

        Exam exam = Exam.builder()
                .attendance(Attendance.builder().idAttendance(idAttendance).build())
                .employee(Employee.builder().idEmployee(idEmployee).build())
                .examType(ExamType.builder().idExamType(idExamType).build())
                .examSituation(ExamSituation.builder().idExamSituation(1L).build())
                .isCompleted(false)
                .build();

        return examRepository.save(exam);
    }

    public List<Exam> findAllPutStatus(Integer status) {
        return examRepository.findAllByExamSituation_Status(status);
    }

    public Exam updateExam(Long idExam, Long idExamSituation, Long idEmployee, UpdateExamRequest request) {

        Exam exam = findExamId(idExam);

        exam.setEmployee(Employee.builder().idEmployee(idEmployee).build());
        exam.setExamSituation(ExamSituation.builder().idExamSituation(idExamSituation).build());
        exam.setIsCompleted(request.isCompleted());
        exam.setResult(request.getResult());

        return examRepository.save(exam);
    }

    public Exam findExamId(Long idExam) {
        return examRepository.findById(idExam).orElse(null);
    }

    public void deleteExam(Long idExam) {
        examRepository.deleteById(idExam);
    }
}
