package com.bsmp.emergency_room.domain.ResponceDTO;

import com.bsmp.emergency_room.domain.enums.Analyses;
import com.bsmp.emergency_room.domain.enums.RadioDiagnostics;
import com.bsmp.emergency_room.domain.enums.Treatment;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseExaminationDTO {

    private UUID id;
    private ResponsePatientDTO patientDTO;
    private ResponseDoctorDTO doctorDTO;
    private String preliminaryDiagnosis;
    private List<Analyses> analyses;
    private List<Treatment> treatment;
    private List<RadioDiagnostics> radioDiagnosis;
}
