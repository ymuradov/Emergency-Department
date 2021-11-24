package com.bsmp.emergency_room.services.implementation;

import com.bsmp.emergency_room.domain.RequestDTO.RequestPatientDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;
import com.bsmp.emergency_room.domain.entity.Patient;
import com.bsmp.emergency_room.mappers.PatientMapper;
import com.bsmp.emergency_room.repository.PatientRepository;
import com.bsmp.emergency_room.services.service_interface.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<ResponsePatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(PatientMapper.INSTANCE::fromEntityToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ResponsePatientDTO getPatientById(UUID patientId) {
        return PatientMapper.INSTANCE.fromEntityToResponseDTO(patientRepository.getById(patientId));
    }

    @Override
    public ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO) {
        Patient patient = PatientMapper.INSTANCE.fromRequestDTO_ToEntity(requestPatientDTO);
        Patient result = patientRepository.save(patient);
        return PatientMapper.INSTANCE.fromEntityToResponseDTO(result);
    }

    @Override
    public ResponsePatientDTO updatePatientById(UUID patientId, RequestPatientDTO requestPatientDTO) {
        Patient patient = PatientMapper.INSTANCE.fromRequestDTO_ToEntity(requestPatientDTO);
        patient.setId(patientId);
        Patient result = patientRepository.save(patient);
        return PatientMapper.INSTANCE.fromEntityToResponseDTO(result);
    }

    @Override
    public void deletePatientById(UUID patientId) {
        Patient patient = patientRepository.getById(patientId);
        patient.setDeleted(true);
        patientRepository.save(patient);
    }
}
