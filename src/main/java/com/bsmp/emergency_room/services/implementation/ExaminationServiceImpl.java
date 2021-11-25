package com.bsmp.emergency_room.services.implementation;

import com.bsmp.emergency_room.domain.RequestDTO.RequestExaminationDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseExaminationDTO;
import com.bsmp.emergency_room.domain.entity.Examination;
import com.bsmp.emergency_room.mappers.ExaminationMapper;
import com.bsmp.emergency_room.repository.ExaminationRepository;
import com.bsmp.emergency_room.services.service_interface.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    public List<ResponseExaminationDTO> getAllExaminations() {
        return examinationRepository.findAll().stream()
                .filter(examination -> !examination.isDeleted())
                .map(ExaminationMapper.INSTANCE::fromEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseExaminationDTO getExaminationById(UUID id) {
        Examination examination = examinationRepository.getById(id);
        if (examination.isDeleted()){
            return null;
        }
        return ExaminationMapper.INSTANCE.fromEntityToResponse(examinationRepository.getById(id));
    }

    @Override
    public ResponseExaminationDTO createExamination(RequestExaminationDTO requestExaminationDTO) {
        Examination examination = ExaminationMapper.INSTANCE.fromRequestToEntity(requestExaminationDTO);
        Examination result = examinationRepository.save(examination);
        return ExaminationMapper.INSTANCE.fromEntityToResponse(result);
    }

    @Override
    public ResponseExaminationDTO updateExaminationById(UUID id, RequestExaminationDTO requestExaminationDTO) {
        Examination examinationFromDB = examinationRepository.getById(id);
        if (examinationFromDB.isDeleted()) {
            return null;
        }
        Examination examinationToDB = ExaminationMapper.INSTANCE.fromRequestToEntity(requestExaminationDTO);
        Examination result = examinationRepository.save(examinationToDB);
        return ExaminationMapper.INSTANCE.fromEntityToResponse(result);
    }

    @Override
    public void deleteExaminationById(UUID id) {
        Examination examinationFromDB = examinationRepository.getById(id);
        if (!examinationFromDB.isDeleted()) {
            examinationFromDB.setDeleted(true);
            examinationRepository.save(examinationFromDB);
        }
    }
}
