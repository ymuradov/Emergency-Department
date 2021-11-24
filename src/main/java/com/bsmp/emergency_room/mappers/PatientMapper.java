package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestPatientDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;
import com.bsmp.emergency_room.domain.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    ResponsePatientDTO fromEntityToResponseDTO(Patient patient);

    Patient fromRequestDTO_ToEntity(RequestPatientDTO patientDTO);
}
