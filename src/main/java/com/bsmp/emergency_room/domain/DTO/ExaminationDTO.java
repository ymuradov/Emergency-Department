package com.bsmp.emergency_room.domain.DTO;

import com.bsmp.emergency_room.domain.enums.Analyses;
import com.bsmp.emergency_room.domain.enums.RadioDiagnostics;
import com.bsmp.emergency_room.domain.enums.Treatment;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationDTO {

    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;
    @NotBlank
    private String preliminaryDiagnosis;
    private List<Analyses> analyses;
    private List<Treatment> treatment;
    private List<RadioDiagnostics> radioDiagnosis;
}
