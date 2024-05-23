package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;
import java.util.List;

import com.porto.lolchamps.domain.role.DadosListagemRole;
import com.porto.lolchamps.domain.role.Role;

public record DadosListagemChamp(
    Long id,
    String name,
    List<DadosListagemRole> roles,
    Integer rpPrice,
    Integer eaPrice,
    LocalDate releaseDate,
    Boolean sale,
    String image,
    Integer percent
) {
    public DadosListagemChamp(Champ champ){
        this(champ.getId(), champ.getName(), champ.getChampRoles().stream().map(Role::new).map(DadosListagemRole::new).toList(), champ.getRpPrice(), champ.getEaPrice(), champ.getReleaseDate(), champ.getSale(), champ.getImage(), champ.getPercent());
    }

}
