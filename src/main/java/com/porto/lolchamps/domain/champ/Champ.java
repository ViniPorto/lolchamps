package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;

import com.porto.lolchamps.domain.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Champ")
@Table(name = "champ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Champ {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "rpprice")
    private int rpPrice;
    @Column(name = "eaprice")
    private int eaPrice;
    @Column(name = "releasedate")
    private LocalDate releaseDate;
    private Boolean sale;
    private String image;
    private Boolean ativo;

    public Champ(DadosCadastroChamp dadosCadastroChamp, Role role){
        this.name = dadosCadastroChamp.name();
        this.role = role;
        this.rpPrice = dadosCadastroChamp.rpPrice();
        this.eaPrice = dadosCadastroChamp.eaPrice();
        this.releaseDate = dadosCadastroChamp.releaseDate();
        this.sale = dadosCadastroChamp.sale();
        this.image = dadosCadastroChamp.image();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosEdicaoChamp dadosEdicaoChamp) {
        if(dadosEdicaoChamp.rpPrice() != null){
            this.rpPrice = dadosEdicaoChamp.rpPrice();
        }
        if(dadosEdicaoChamp.eaPrice() != null){
            this.eaPrice = dadosEdicaoChamp.eaPrice();
        }
        if(dadosEdicaoChamp.sale() != null){
            this.sale = dadosEdicaoChamp.sale();
        }
        if(dadosEdicaoChamp.image() != null){
            this.image = dadosEdicaoChamp.image();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
