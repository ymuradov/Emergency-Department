package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestDoctorDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseDoctorDTO;
import com.bsmp.emergency_room.domain.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    ResponseDoctorDTO fromEntityToResponse(Doctor doctor);

    Doctor fromRequestToEntity(RequestDoctorDTO requestDoctorDTO);
}
