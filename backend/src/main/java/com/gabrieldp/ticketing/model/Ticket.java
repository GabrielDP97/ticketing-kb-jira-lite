package com.gabrieldp.ticketing.model;

import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private LocalDateTime createAt;

    public Ticket(long l, String noPuedoIniciarSesión, String s, TicketStatus ticketStatus, LocalDateTime localDateTime) {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}