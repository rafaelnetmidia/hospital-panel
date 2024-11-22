package br.com.hospital.painel.hospitalpanel.request.attendance;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateAttendanceRequest {

    private Long idAttendanceSituation;

}
