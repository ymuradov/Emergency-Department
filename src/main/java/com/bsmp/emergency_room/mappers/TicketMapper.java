package com.bsmp.emergency_room.mappers;

import com.bsmp.emergency_room.domain.RequestDTO.RequestTicketDTO;
import com.bsmp.emergency_room.domain.ResponceDTO.ResponseTicketDTO;
import com.bsmp.emergency_room.domain.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    ResponseTicketDTO fromEntityToResponse(Ticket ticket);

    Ticket fromRequestToEntity(RequestTicketDTO requestTicketDTO);
}
