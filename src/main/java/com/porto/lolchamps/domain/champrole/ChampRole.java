package com.porto.lolchamps.domain.champrole;

import com.porto.lolchamps.domain.champ.Champ;
import com.porto.lolchamps.domain.role.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ChampRole")
@Table(name = "champ_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ChampRole {
    
    public ChampRole(Role role, Champ champ) {
        this.champ = champ;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "champ_id")
    private Champ champ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
