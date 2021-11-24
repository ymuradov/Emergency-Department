package com.bsmp.emergency_room.domain.ResponceDTO;

import com.bsmp.emergency_room.domain.enums.Symptom;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseTicketDTO {

    private UUID id;
    private ResponsePatientDTO patientDTO;
    private ResponseDoctorDTO doctorDTO;
    private List<Symptom> symptoms;
}
