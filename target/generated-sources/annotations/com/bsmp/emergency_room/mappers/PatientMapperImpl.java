package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestPatientDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;
import com.bsmp.emergency_room.domain.entity.Patient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-25T09:16:20+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public ResponsePatientDTO fromEntityToResponseDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        ResponsePatientDTO responsePatientDTO = new ResponsePatientDTO();

        responsePatientDTO.setId( patient.getId() );
        responsePatientDTO.setFirstName( patient.getFirstName() );
        responsePatientDTO.setLastName( patient.getLastName() );
        responsePatientDTO.setBirthDay( patient.getBirthDay() );
        responsePatientDTO.setSex( patient.getSex() );
        responsePatientDTO.setMedicalInsuranceNumber( patient.getMedicalInsuranceNumber() );
        responsePatientDTO.setEmail( patient.getEmail() );

        return responsePatientDTO;
    }

    @Override
    public Patient fromRequestDTO_ToEntity(RequestPatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setFirstName( patientDTO.getFirstName() );
        patient.setLastName( patientDTO.getLastName() );
        patient.setBirthDay( patientDTO.getBirthDay() );
        patient.setSex( patientDTO.getSex() );
        patient.setMedicalInsuranceNumber( patientDTO.getMedicalInsuranceNumber() );
        patient.setEmail( patientDTO.getEmail() );

        return patient;
    }
}
