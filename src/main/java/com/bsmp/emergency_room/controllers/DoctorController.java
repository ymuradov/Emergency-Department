package com.bsmp.emergency_room.controllers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestDoctorDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseDoctorDTO;
import com.bsmp.emergency_room.services.service_interface.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<HttpStatus> getAllDoctors() {
        List<ResponseDoctorDTO> doctors = doctorService.getAllDoctors();
        if (doctors != null) {
            return new ResponseEntity(doctors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getDoctorById(@PathVariable UUID id) {
        ResponseDoctorDTO responseDoctorDTO = doctorService.getDoctorById(id);
        if (responseDoctorDTO != null) {
            return new ResponseEntity(responseDoctorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createDoctor(@RequestBody RequestDoctorDTO requestDoctorDTO) {
        ResponseDoctorDTO responseDoctorDTO = doctorService.createDoctor(requestDoctorDTO);
        if (responseDoctorDTO != null) {
            return new ResponseEntity(responseDoctorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateDoctorById(@PathVariable UUID id, @RequestBody RequestDoctorDTO requestDoctorDTO) {
        ResponseDoctorDTO responseDoctorDTO = doctorService.updateDoctorById(id, requestDoctorDTO);
        if (responseDoctorDTO != null) {
            return new ResponseEntity(responseDoctorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDoctorById(@PathVariable UUID id) {
        doctorService.deleteDoctorById(id);
        return "Doctor with ID = " + id + " was deleted";
    }
}
