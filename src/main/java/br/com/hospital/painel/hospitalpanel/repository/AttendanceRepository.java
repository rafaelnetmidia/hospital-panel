package br.com.hospital.painel.hospitalpanel.repository;

import br.com.hospital.painel.hospitalpanel.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByAttendanceSituationIdAttendanceSituation(Long status);

    Attendance findByIdAttendance(Long idAttendance);
}
