package com.porto.lolchamps.domain.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoRole(
    @NotNull
    Long id,
    @NotBlank
    String name
) {
    
}
