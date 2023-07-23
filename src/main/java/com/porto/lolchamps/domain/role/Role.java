package com.porto.lolchamps.domain.role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Role")
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {
    
    public Role(@Valid DadosCadastroRole dadosCadastroRole) {
        this.name = dadosCadastroRole.name();
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean ativo;

    public void atualizarInformacoes(@Valid DadosEdicaoRole dadosEdicaoRole) {
        this.name = dadosEdicaoRole.name();
    }

    public void excluir() {
        this.ativo = false;
    }

}
