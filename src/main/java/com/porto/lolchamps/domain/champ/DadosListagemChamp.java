package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;

import com.porto.lolchamps.domain.role.DadosListagemRole;

public record DadosListagemChamp(
    Long id,
    String name,
    DadosListagemRole role,
    Integer rpPrice,
    Integer eaPrice,
    LocalDate releaseDate,
    Boolean sale,
    String image
) {
    public DadosListagemChamp(Champ champ){
        this(champ.getId(), champ.getName(), new DadosListagemRole(champ.getRole()), champ.getRpPrice(), champ.getEaPrice(), champ.getReleaseDate(), champ.getSale(), champ.getImage());
    }

}
