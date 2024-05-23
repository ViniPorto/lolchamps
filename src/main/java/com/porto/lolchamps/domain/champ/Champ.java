package com.porto.lolchamps.domain.champ;

import java.time.LocalDate;
import java.util.List;

import com.porto.lolchamps.domain.champrole.ChampRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "champ")
    private List<ChampRole> champRoles;
    @Column(name = "rpprice")
    private int rpPrice;
    @Column(name = "eaprice")
    private int eaPrice;
    @Column(name = "releasedate")
    private LocalDate releaseDate;
    private Boolean sale;
    private String image;
    private Boolean ativo;
    private Integer percent;

    public Champ(DadosCadastroChamp dadosCadastroChamp){
        this.name = dadosCadastroChamp.name();
        this.champRoles = null;
        this.rpPrice = dadosCadastroChamp.rpPrice();
        this.eaPrice = dadosCadastroChamp.eaPrice();
        this.releaseDate = dadosCadastroChamp.releaseDate();
        this.sale = dadosCadastroChamp.sale();
        this.image = dadosCadastroChamp.image();
        this.ativo = true;
        this.percent = dadosCadastroChamp.percent();
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
        if(dadosEdicaoChamp.percent() != null){
            this.percent = dadosEdicaoChamp.percent();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
