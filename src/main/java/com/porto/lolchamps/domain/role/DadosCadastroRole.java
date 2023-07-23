package com.porto.lolchamps.domain.role;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRole(
    @NotBlank
    String name
) {
    
}
