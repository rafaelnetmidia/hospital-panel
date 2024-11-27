package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Exam;
import br.com.hospital.painel.hospitalpanel.request.exam.UpdateExamRequest;
import br.com.hospital.painel.hospitalpanel.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/exams")
@AllArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping("/register/attendance/{idAttendance}/exam-type/{idExamType}/employee/{idEmployee}")
    public ResponseEntity<String> registerExam(@PathVariable Long idAttendance, @PathVariable Long idExamType, @PathVariable Long idEmployee) {

        Exam exam = examService.registerExam(idAttendance, idExamType, idEmployee);

        if (exam != null) {
            return ResponseEntity.created(URI.create("/attendances/" + exam.getIdExam())).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/find-all/id-status/{status}")
    public ResponseEntity<List<Exam>> findAllPutStatus(@PathVariable Integer status) {

        List<Exam> exams = examService.findAllPutStatus(status);

        if(exams.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(exams);
    }

    @GetMapping("/find/exam/{idExam}")
    public ResponseEntity<Exam> findExamId(@PathVariable Long idExam) {

        Exam exams = examService.findExamId(idExam);

        if(exams == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(exams);
    }

    @PutMapping("exam/{idExam}/exam-situation/{idExamSituation}/employee/{idEmployee}")
    public ResponseEntity<URI> updateExam(@PathVariable Long idExam, @PathVariable Long idExamSituation, @PathVariable Long idEmployee, @RequestBody UpdateExamRequest request) {

        Exam exam = examService.updateExam(idExam, idExamSituation, idEmployee, request);

        if (exam == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(URI.create("exams/find/exam/" + exam.getIdExam()));
    }

    @DeleteMapping("exam/{idExam}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long idExam) {
        examService.deleteExam(idExam);
        return ResponseEntity.ok().build();
    }

}
