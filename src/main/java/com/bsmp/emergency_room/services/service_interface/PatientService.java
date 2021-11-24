package com.bsmp.emergency_room.services.service_interface;

import com.bsmp.emergency_room.domain.RequestDTO.RequestPatientDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<ResponsePatientDTO> getAllPatients();

    ResponsePatientDTO getPatientById(UUID patientId);

    ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO);

    ResponsePatientDTO updatePatientById(UUID patientId, RequestPatientDTO requestPatientDTO);

    void deletePatientById(UUID patientId);
}
