package com.bsmp.emergency_room.services.service_interface;

import com.bsmp.emergency_room.domain.RequestDTO.RequestDoctorDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseDoctorDTO;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<ResponseDoctorDTO> getAllDoctors();

    ResponseDoctorDTO getDoctorById(UUID id);

    ResponseDoctorDTO createDoctor(RequestDoctorDTO requestDoctorDTO);

    ResponseDoctorDTO updateDoctorById(UUID id, RequestDoctorDTO requestDoctorDTO);

    void deleteDoctorById(UUID id);
}
