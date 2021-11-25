package com.bsmp.emergency_room.services.service_interface;

import com.bsmp.emergency_room.domain.RequestDTO.RequestTicketDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseTicketDTO;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    List<ResponseTicketDTO> getAllTickets();

    ResponseTicketDTO getTicketById(UUID id);

    ResponseTicketDTO createTicket(RequestTicketDTO requestTicketDTO);

    ResponseTicketDTO updateTicketById(UUID id, RequestTicketDTO requestTicketDTO);

    void deleteTicketById(UUID id);
}
