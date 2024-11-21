package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.*;
import br.com.hospital.painel.hospitalpanel.repository.AttendanceRepository;
import br.com.hospital.painel.hospitalpanel.request.attendance.UpdateAttendanceRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public Attendance registerAttendance(Long idPatient) {

        Attendance attendance = Attendance
                .builder()
                .patient(Patient.builder().idPatient(idPatient).build())
                .attendanceSituation(AttendanceSituation.builder().idAttendanceSituation(1L).build())
                .build();

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findAllPutStatus(Long status) {
        return attendanceRepository.findByAttendanceSituationIdAttendanceSituation(status);
    }

    public Attendance findAttendance(Long idAttendance) {
        return attendanceRepository.findByIdAttendance(idAttendance);
    }

    public Attendance updateAttendance(Long idAttendance, Long idEmployee, UpdateAttendanceRequest request) {

        Attendance attendance = findAttendance(idAttendance);

        attendance.setEmployee(Employee.builder().idEmployee(idEmployee).build());
        attendance.setAttendanceSituation(AttendanceSituation.builder().idAttendanceSituation(request.getIdAttendanceSituation()).build());

        return attendanceRepository.save(attendance);

    }

    public void deleteAttendance(Long idAttendance) {
        attendanceRepository.deleteById(idAttendance);
    }
}
