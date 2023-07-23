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

import com.porto.lolchamps.domain.champ.DadosCadastroChamp;
import com.porto.lolchamps.domain.champ.DadosEdicaoChamp;
import com.porto.lolchamps.domain.champ.DadosListagemChamp;
import com.porto.lolchamps.service.ChampService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/champ")
public class ChampController {
    
    @Autowired
    private ChampService champService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemChamp>> listarChamps(Pageable paginacao){
        var champs = champService.listarChamps(paginacao);

        return ResponseEntity.ok(champs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemChamp> detalharChamp(@PathVariable Long id){
        var champ = champService.detalharChamp(id);
        var listagem = new DadosListagemChamp(champ);

        return ResponseEntity.ok(listagem);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemChamp> cadastrarChamp(@RequestBody @Valid DadosCadastroChamp dadosCadastroChamp, UriComponentsBuilder uriComponentsBuilder){
        var champ = champService.cadastrarChamp(dadosCadastroChamp);

        var uri = uriComponentsBuilder.path("/champ/{id}").buildAndExpand(champ.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemChamp(champ));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemChamp> alterarChamp(@RequestBody @Valid DadosEdicaoChamp dadosEdicaoChamp){
        var champ = champService.alterarChamp(dadosEdicaoChamp);

        return ResponseEntity.ok(new DadosListagemChamp(champ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirChamp(@PathVariable Long id){
        champService.excluirChamp(id);

        return ResponseEntity.noContent().build();
    }

}
