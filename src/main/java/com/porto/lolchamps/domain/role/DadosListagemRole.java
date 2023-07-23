package com.porto.lolchamps.domain.role;

public record DadosListagemRole(
    Long id,
    String name
) {
    public DadosListagemRole(Role role){
        this(role.getId(), role.getName());
    }
}
