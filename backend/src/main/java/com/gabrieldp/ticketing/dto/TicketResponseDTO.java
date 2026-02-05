package com.gabrieldp.ticketing.dto;

import com.gabrieldp.ticketing.model.TicketStatus;

import java.time.LocalDateTime;

public class TicketResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private LocalDateTime createdAt;

    public TicketResponseDTO(Long id, String title, String description, TicketStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
