package com.gabrieldp.ticketing.controller;

import com.gabrieldp.ticketing.dto.TicketCreateRequestDTO;
import com.gabrieldp.ticketing.model.Ticket;
import com.gabrieldp.ticketing.model.TicketStatus;
import com.gabrieldp.ticketing.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.gabrieldp.ticketing.dto.TicketResponseDTO;
import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<TicketResponseDTO> getTickets(
            @RequestParam(required = false) TicketStatus status
    ) {
        if (status != null) {
            return ticketService.findByStatus(status);
        }
        return ticketService.findAll();
    }

    @PostMapping("/tickets")
    public TicketResponseDTO createTicket(
            @Valid @RequestBody TicketCreateRequestDTO request
    ) {
        return ticketService.create(request);
    }


}

