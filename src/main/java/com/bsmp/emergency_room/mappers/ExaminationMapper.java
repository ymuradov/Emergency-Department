package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestExaminationDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseExaminationDTO;
import com.bsmp.emergency_room.domain.entity.Examination;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExaminationMapper {
    ExaminationMapper INSTANCE = Mappers.getMapper(ExaminationMapper.class);

    ResponseExaminationDTO fromEntityToResponse(Examination examination);

    Examination fromRequestToEntity(RequestExaminationDTO examinationDTO);
}
