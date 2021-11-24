package com.bsmp.emergency_room.controllers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestPatientDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponsePatientDTO;
import com.bsmp.emergency_room.services.service_interface.PatientService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<HttpStatus> getAllPatients() {
        List<ResponsePatientDTO> patients = patientService.getAllPatients();
        if (patients != null) {
            return new ResponseEntity(patients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getPatientById(@PathVariable UUID id) {
        ResponsePatientDTO patientDTO = patientService.getPatientById(id);
        if (patientDTO != null) {
            return new ResponseEntity(patientDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPatient(@RequestBody RequestPatientDTO patientDTO) {
        ResponsePatientDTO responseDTO = patientService.createPatient(patientDTO);
        if (responseDTO != null) {
            return new ResponseEntity( responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePatientById(@PathVariable UUID id, @RequestBody RequestPatientDTO patientDTO) {
        ResponsePatientDTO responsePatientDTO = patientService.updatePatientById(id, patientDTO);
        if (responsePatientDTO != null) {
            return new ResponseEntity(responsePatientDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable UUID id) {
        patientService.deletePatientById(id);
        return  "Patient with ID = " + id + " was deleted";
    }
}
