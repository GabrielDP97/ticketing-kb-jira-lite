package com.gabrieldp.ticketing.dto;

import jakarta.validation.constraints.NotBlank;

public class TicketCreateRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    public TicketCreateRequestDTO() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
