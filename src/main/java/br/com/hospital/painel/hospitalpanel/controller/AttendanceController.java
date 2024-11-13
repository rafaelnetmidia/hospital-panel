package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Attendance;
import br.com.hospital.painel.hospitalpanel.request.attendance.UpdateAttendanceRequest;
import br.com.hospital.painel.hospitalpanel.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/attendances")
@AllArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/register/{idPatient}")
    public ResponseEntity<String> registerAttendance(@PathVariable Long idPatient) {

        Attendance attendance = attendanceService.registerAttendance(idPatient);

        if (attendance != null) {
            return ResponseEntity.created(URI.create("/attendances/" + attendance.getIdAttendance())).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/find-all/id-status/{status}")
    public ResponseEntity<List<Attendance>> findAllPutStatus(@PathVariable Long status) {

        List<Attendance> attendances = attendanceService.findAllPutStatus(status);

        if(attendances.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(attendances);
    }

    @GetMapping("attendance/{idAttendance}")
    public ResponseEntity<Attendance> findAttendance(@PathVariable Long idAttendance) {

        Attendance attendance = attendanceService.findAttendance(idAttendance);

        if(attendance == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(attendance);
    }

    @PutMapping("attendance/{idAttendance}/employee/{idEmployee}")
    public ResponseEntity<URI> updateAttendance(@PathVariable Long idAttendance, @PathVariable Long idEmployee, @RequestBody UpdateAttendanceRequest request) {
        Attendance attendance = attendanceService.updateAttendance(idAttendance, idEmployee, request);

        if (attendance == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(URI.create("/attendances/attendance/" + attendance.getIdAttendance()));
    }

    @DeleteMapping("attendance/{idAttendance}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long idAttendance) {
        attendanceService.deleteAttendance(idAttendance);
        return ResponseEntity.ok().build();
    }

}
