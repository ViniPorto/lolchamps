package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record DadosCadastroChamp(
    @NotBlank
    String name,
    @NotNull
    List<Long> idRoles,
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
