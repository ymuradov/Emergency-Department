package com.bsmp.emergency_room.repository;

import com.bsmp.emergency_room.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
