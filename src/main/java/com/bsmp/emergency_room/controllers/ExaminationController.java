package com.bsmp.emergency_room.controllers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestExaminationDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseExaminationDTO;
import com.bsmp.emergency_room.services.service_interface.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examinations")
public class ExaminationController {

    private final ExaminationService examinationService;

    @GetMapping
    public ResponseEntity<HttpStatus> getAllExaminations() {
        List<ResponseExaminationDTO> examinationDTOList = examinationService.getAllExaminations();
        if (examinationDTOList == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(examinationDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getExaminationById(@PathVariable UUID id) {
        ResponseExaminationDTO responseExaminationDTO = examinationService.getExaminationById(id);
        if (responseExaminationDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(responseExaminationDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createExamination(@RequestBody RequestExaminationDTO requestExaminationDTO) {
        ResponseExaminationDTO responseExaminationDTO = examinationService.createExamination(requestExaminationDTO);
        if  (responseExaminationDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(responseExaminationDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateExaminationById(@PathVariable UUID id, @RequestBody RequestExaminationDTO requestExaminationDTO) {
        ResponseExaminationDTO responseExaminationDTO = examinationService.updateExaminationById(id, requestExaminationDTO);
        if (responseExaminationDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(responseExaminationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteExaminationById(@PathVariable UUID id) {
        examinationService.deleteExaminationById(id);
        return "Examination with ID = " + id + " was deleted";
    }

}
