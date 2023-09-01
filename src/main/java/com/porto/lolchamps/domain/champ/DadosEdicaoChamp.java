package com.porto.lolchamps.domain.champ;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoChamp(
    @NotNull
    Long id,
    Integer rpPrice,
    Integer eaPrice,
    Boolean sale,
    String image,
    @Min(0)
    @Max(255)
    Integer percent
) {
    
}
