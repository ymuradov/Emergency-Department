package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;
import com.bsmp.emergency_room.domain.entity.Patient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-24T23:48:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public ResponsePatientDTO fromEntityToResponseDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        ResponsePatientDTO patientDTO = new ResponsePatientDTO();

        patientDTO.setId( patient.getId() );
        patientDTO.setFirstName( patient.getFirstName() );
        patientDTO.setLastName( patient.getLastName() );
        patientDTO.setBirthDay( patient.getBirthDay() );
        patientDTO.setSex( patient.getSex() );
        patientDTO.setMedicalInsuranceNumber( patient.getMedicalInsuranceNumber() );
        patientDTO.setEmail( patient.getEmail() );

        return patientDTO;
    }

    @Override
    public Patient fromRequestDTO_ToEntity(ResponsePatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.getId() );
        patient.setFirstName( patientDTO.getFirstName() );
        patient.setLastName( patientDTO.getLastName() );
        patient.setBirthDay( patientDTO.getBirthDay() );
        patient.setSex( patientDTO.getSex() );
        patient.setMedicalInsuranceNumber( patientDTO.getMedicalInsuranceNumber() );
        patient.setEmail( patientDTO.getEmail() );

        return patient;
    }
}
