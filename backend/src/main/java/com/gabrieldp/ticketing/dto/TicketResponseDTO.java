package com.gabrieldp.ticketing.dto;

import com.gabrieldp.ticketing.model.TicketStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Ticket response DTO")
public class TicketResponseDTO {

    @Schema(
            description = "Ticket identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(
            description = "Ticket title",
            example = "Login error"
    )
    private String title;

    @Schema(
            description = "Ticket description",
            example = "User cannot login into the platform"
    )
    private String description;

    @Schema(
            description = "Current ticket status",
            example = "OPEN"
    )
    private TicketStatus status;

    @Schema(
            description = "Ticket creation timestamp",
            example = "2026-02-05T18:30:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    public TicketResponseDTO(
            Long id,
            String title,
            String description,
            TicketStatus status,
            LocalDateTime createdAt
    ) {
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

