package com.gabrieldp.ticketing.service;

import com.gabrieldp.ticketing.dto.TicketCreateRequestDTO;
import com.gabrieldp.ticketing.model.Ticket;
import com.gabrieldp.ticketing.model.TicketStatus;
import org.springframework.stereotype.Service;
import com.gabrieldp.ticketing.dto.TicketResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final List<Ticket> tickets = new ArrayList<>();

    public TicketResponseDTO create(TicketCreateRequestDTO request) {

        Ticket ticket = new Ticket(
                (long) (tickets.size() + 1),
                request.getTitle(),
                request.getDescription(),
                TicketStatus.OPEN,
                LocalDateTime.now()
        );

        tickets.add(ticket);

        return toDto(ticket);
    }

    public List<TicketResponseDTO> findAll() {
        return tickets.stream()
                .map(this::toDto)
                .toList();
    }

    public List<TicketResponseDTO> findByStatus(TicketStatus status) {
        return tickets.stream()
                .filter(ticket -> ticket.getStatus() == status)
                .map(this::toDto)
                .toList();
    }

    private TicketResponseDTO toDto(Ticket ticket) {
        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getCreateAt()
        );
    }
}
