package com.bsmp.emergency_room.controllers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestTicketDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseTicketDTO;
import com.bsmp.emergency_room.services.service_interface.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<HttpStatus> getAllTickets(){
        List<ResponseTicketDTO> tickets = ticketService.getAllTickets();
        if (tickets != null) {
            return new ResponseEntity(tickets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getTicketById(@PathVariable UUID id) {
        ResponseTicketDTO responseTicketDTO = ticketService.getTicketById(id);
        if (responseTicketDTO != null) {
            return new ResponseEntity(responseTicketDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createTicket(@RequestBody RequestTicketDTO requestTicketDTO) {
        ResponseTicketDTO responseTicketDTO = ticketService.createTicket(requestTicketDTO);
        if (responseTicketDTO != null) {
            return new ResponseEntity(responseTicketDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateTicketById(@PathVariable UUID id, @RequestBody RequestTicketDTO requestTicketDTO) {
        ResponseTicketDTO responseTicketDTO = ticketService.updateTicketById(id, requestTicketDTO);
        if (responseTicketDTO != null) {
            return new ResponseEntity(responseTicketDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable UUID id) {
        ticketService.deleteTicketById(id);
        return "Ticket with ID = " + id + " was deleted";
    }
}
