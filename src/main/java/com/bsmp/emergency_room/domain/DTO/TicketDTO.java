package com.bsmp.emergency_room.domain.DTO;

import com.bsmp.emergency_room.domain.enums.Symptom;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketDTO {
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;
    private List<Symptom> symptoms;
}
