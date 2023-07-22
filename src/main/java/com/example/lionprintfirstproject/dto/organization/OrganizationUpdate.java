package com.example.lionprintfirstproject.dto.organization;

import jakarta.validation.constraints.NotBlank;

public record OrganizationUpdate(@NotBlank(message = "error.invalid.name.not_blank") String name, String info) {
}
