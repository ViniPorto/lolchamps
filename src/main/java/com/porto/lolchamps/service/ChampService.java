package com.porto.lolchamps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.porto.lolchamps.domain.champ.Champ;
import com.porto.lolchamps.domain.champ.ChampRepository;
import com.porto.lolchamps.domain.champ.DadosCadastroChamp;
import com.porto.lolchamps.domain.champ.DadosEdicaoChamp;
import com.porto.lolchamps.domain.champ.DadosListagemChamp;
import com.porto.lolchamps.domain.champrole.ChampRole;
import com.porto.lolchamps.domain.role.RoleRepository;
import com.porto.lolchamps.infra.exception.exceptions.ChampInativoException;

import jakarta.validation.Valid;

@Service
public class ChampService {
    
    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Page<DadosListagemChamp> listarChamps(Pageable paginacao, String name, List<Long> roles, Boolean sale) {
        if(name == null && roles == null){
            return champRepository.findAllByAtivoTrue(paginacao, sale).map(DadosListagemChamp::new);
        }else if(name != null && roles == null){
            return champRepository.findAllFiltroPorName(paginacao, name, sale).map(DadosListagemChamp::new);
        }else if(name == null && roles != null){
            return champRepository.findAllFiltroPorRole(paginacao, roles, sale, roles.size()).map(DadosListagemChamp::new);
        }
        return champRepository.findAllFiltroPorRoleEName(paginacao, name, roles, sale, roles.size()).map(DadosListagemChamp::new);
    }

    public Champ detalharChamp(Long id) {
        var champ = champRepository.getReferenceById(id);
        validaSeEstaAtivo(champ);
        return champ;
    }

    public Champ cadastrarChamp(@Valid DadosCadastroChamp dadosCadastroChamp) {
        var roles = roleRepository.listarRolesPorIds(dadosCadastroChamp.idRoles());
        var champ = new Champ(dadosCadastroChamp);

        champRepository.save(champ);

        List<ChampRole> champRoles = roles.stream().map(role -> new ChampRole(role, champ)).toList();
        champ.setChampRoles(champRoles);

        return champRepository.save(champ);
    }

    public Champ alterarChamp(@Valid DadosEdicaoChamp dadosEdicaoChamp) {
        var champ = champRepository.getReferenceById(dadosEdicaoChamp.id());
        validaSeEstaAtivo(champ);

        champ.atualizarInformacoes(dadosEdicaoChamp);

        return champ;
    }

    public void excluirChamp(Long id) {
        var champ = champRepository.getReferenceById(id);
        validaSeEstaAtivo(champ);

        champ.excluir();
    }
 
    private void validaSeEstaAtivo(Champ champ){
        if(!champ.getAtivo()){
            throw new ChampInativoException("Campeao informado encontra-se inativo!");
        }
    }

}
