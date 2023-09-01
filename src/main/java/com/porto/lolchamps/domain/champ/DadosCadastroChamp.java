package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record DadosCadastroChamp(
    @NotBlank
    String name,
    @NotNull
    Long idRole,
    @NotNull
    Integer rpPrice,
    @NotNull
    Integer eaPrice,
    @NotNull
    @PastOrPresent
    LocalDate releaseDate,
    @NotNull
    Boolean sale,
    @NotBlank
    String image,
    @NotNull
    @Min(0)
    @Max(255)
    Integer percent
) {
    
}
