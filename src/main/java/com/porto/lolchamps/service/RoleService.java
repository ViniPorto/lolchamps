package com.porto.lolchamps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.porto.lolchamps.domain.role.DadosCadastroRole;
import com.porto.lolchamps.domain.role.DadosEdicaoRole;
import com.porto.lolchamps.domain.role.DadosListagemRole;
import com.porto.lolchamps.domain.role.Role;
import com.porto.lolchamps.domain.role.RoleRepository;
import com.porto.lolchamps.infra.exception.exceptions.RoleInativaException;

import jakarta.validation.Valid;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    public Page<DadosListagemRole> listarRoles(Pageable paginacao) {
        return roleRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRole::new);
    }

    public Role cadastrarRole(@Valid DadosCadastroRole dadosCadastroRole) {
        return roleRepository.save(new Role(dadosCadastroRole));
    }

    public Role detalhar(Long id) {
        var role = roleRepository.getReferenceById(id);
        validaSeEstaAtivo(role);

        return role;
    }

    public Role alterarRole(@Valid DadosEdicaoRole dadosEdicaoRole) {
        var role = roleRepository.getReferenceById(dadosEdicaoRole.id());
        validaSeEstaAtivo(role);
        role.atualizarInformacoes(dadosEdicaoRole);
        
        return role;
    }

    public void excluirRole(Long id) {
        var role = roleRepository.getReferenceById(id);
        validaSeEstaAtivo(role);

        role.excluir();
    }

    private void validaSeEstaAtivo(Role role){
        if(!role.getAtivo()){
            throw new RoleInativaException("Role informada encontra-se inativa!");
        }
    }


}
