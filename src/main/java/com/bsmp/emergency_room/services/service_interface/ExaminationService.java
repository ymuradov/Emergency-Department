package com.bsmp.emergency_room.services.service_interface;

import com.bsmp.emergency_room.domain.RequestDTO.RequestExaminationDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseExaminationDTO;

import java.util.List;
import java.util.UUID;

public interface ExaminationService {
    List<ResponseExaminationDTO> getAllExaminations();

    ResponseExaminationDTO getExaminationById(UUID id);

    ResponseExaminationDTO createExamination(RequestExaminationDTO requestExaminationDTO);

    ResponseExaminationDTO updateExaminationById(UUID id, RequestExaminationDTO requestExaminationDTO);

    void deleteExaminationById(UUID id);
}
