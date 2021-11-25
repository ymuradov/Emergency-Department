package com.bsmp.emergency_room.services.implementation;

import com.bsmp.emergency_room.domain.RequestDTO.RequestDoctorDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseDoctorDTO;
import com.bsmp.emergency_room.domain.entity.Doctor;
import com.bsmp.emergency_room.mappers.DoctorMapper;
import com.bsmp.emergency_room.repository.DoctorRepository;
import com.bsmp.emergency_room.services.service_interface.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    @Override
    public List<ResponseDoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .filter(doctor -> !doctor.isDeleted())
                .map(DoctorMapper.INSTANCE::fromEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDoctorDTO getDoctorById(UUID id) {
        Doctor doctor = doctorRepository.getById(id);
        if (doctor.isDeleted()) {
            return null;
        } else {
            return DoctorMapper.INSTANCE.fromEntityToResponse(doctor);
        }
    }

    @Override
    public ResponseDoctorDTO createDoctor(RequestDoctorDTO requestDoctorDTO) {
        Doctor doctor = DoctorMapper.INSTANCE.fromRequestToEntity(requestDoctorDTO);
        Doctor result = doctorRepository.save(doctor);
        return DoctorMapper.INSTANCE.fromEntityToResponse(result);
    }

    @Override
    public ResponseDoctorDTO updateDoctorById(UUID id, RequestDoctorDTO requestDoctorDTO) {
        Doctor doctorFromDB = doctorRepository.getById(id);
        if (!doctorFromDB.isDeleted()) {
            Doctor doctorToDB = DoctorMapper.INSTANCE.fromRequestToEntity(requestDoctorDTO);
            doctorToDB.setId(id);
            Doctor result = doctorRepository.save(doctorToDB);
            return DoctorMapper.INSTANCE.fromEntityToResponse(result);
        } else return null;
    }

    @Override
    public void deleteDoctorById(UUID id) {
        Doctor doctor = doctorRepository.getById(id);
        if (!doctor.isDeleted()) {
            doctor.setDeleted(true);
            doctorRepository.save(doctor);
        }
    }
}
