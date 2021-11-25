package com.bsmp.emergency_room.services.implementation;

import com.bsmp.emergency_room.domain.RequestDTO.RequestTicketDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseTicketDTO;
import com.bsmp.emergency_room.domain.entity.Ticket;
import com.bsmp.emergency_room.mappers.TicketMapper;
import com.bsmp.emergency_room.repository.TicketRepository;
import com.bsmp.emergency_room.services.service_interface.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional()
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<ResponseTicketDTO> getAllTickets() {
        return ticketRepository.findAll().stream()
                .filter(ticket -> !ticket.isDeleted())
                .map(TicketMapper.INSTANCE::fromEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseTicketDTO getTicketById(UUID id) {
        Ticket ticket = ticketRepository.getById(id);
        if (ticket.isDeleted()) {
            return null;
        }
        return TicketMapper.INSTANCE.fromEntityToResponse(ticketRepository.getById(id));
    }

    @Override
    public ResponseTicketDTO createTicket(RequestTicketDTO requestTicketDTO) {
        Ticket ticket = TicketMapper.INSTANCE.fromRequestToEntity(requestTicketDTO);
        Ticket result = ticketRepository.save(ticket);
        return TicketMapper.INSTANCE.fromEntityToResponse(result);
    }

    @Override
    public ResponseTicketDTO updateTicketById(UUID id, RequestTicketDTO requestTicketDTO) {
        Ticket ticketFromDB = ticketRepository.getById(id);
        if (ticketFromDB.isDeleted()) {
            return null;
        }
        Ticket ticketToDB = TicketMapper.INSTANCE.fromRequestToEntity(requestTicketDTO);
        Ticket result = ticketRepository.save(ticketToDB);
        return TicketMapper.INSTANCE.fromEntityToResponse(result);
    }

    @Override
    public void deleteTicketById(UUID id) {
        Ticket ticket = ticketRepository.getById(id);
        if (!ticket.isDeleted()) {
            ticket.setDeleted(true);
            ticketRepository.save(ticket);
        }
    }
}
