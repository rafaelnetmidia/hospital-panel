package br.com.hospital.painel.hospitalpanel.request.exam;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateExamRequest {

    private boolean isCompleted;
    private String result;

}
