package com.porto.lolchamps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.porto.lolchamps.domain.role.DadosCadastroRole;
import com.porto.lolchamps.domain.role.DadosEdicaoRole;
import com.porto.lolchamps.domain.role.DadosListagemRole;
import com.porto.lolchamps.service.RoleService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemRole>> listarRoles(Pageable paginacao){
        var roles = roleService.listarRoles(paginacao);

        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemRole> detalharRole(@PathVariable Long id){
        var role = roleService.detalhar(id);
        var listagem = new DadosListagemRole(role);

        return ResponseEntity.ok(listagem);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemRole> cadastrarRole(@RequestBody @Valid DadosCadastroRole dadosCadastroRole, UriComponentsBuilder uriComponentsBuilder){
        var role = roleService.cadastrarRole(dadosCadastroRole);

        var uri = uriComponentsBuilder.path("/role/{id}").buildAndExpand(role.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemRole(role));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemRole> alterarRole(@RequestBody @Valid DadosEdicaoRole dadosEdicaoRole){
        var role = roleService.alterarRole(dadosEdicaoRole);
        var listagem = new DadosListagemRole(role);

        return ResponseEntity.ok(listagem);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirRole(@PathVariable Long id){
        roleService.excluirRole(id);

        return ResponseEntity.noContent().build();
    }


}
