package com.bsmp.emergency_room.domain.RequestDTO;


import com.bsmp.emergency_room.domain.enums.Symptom;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestTicketDTO {

    private RequestPatientDTO patientDTO;
    private RequestDoctorDTO requestDoctorDTO;
    private List<Symptom> symptoms;
}
