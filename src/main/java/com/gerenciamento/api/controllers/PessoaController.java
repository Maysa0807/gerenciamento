package com.gerenciamento.api.controllers;

import com.gerenciamento.api.dto.PessoaDto;
import com.gerenciamento.api.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> getAllPessoas(){

        return ResponseEntity.ok(pessoaService.getPessoas());
    }
    @PostMapping
    public ResponseEntity<PessoaDto> registerPessoa(@RequestBody @Valid PessoaDto data){
        return ResponseEntity.ok(pessoaService.save(data));
    }
    @PutMapping
    public ResponseEntity<PessoaDto>  updatePessoa(@RequestBody @Valid PessoaDto data){
        return ResponseEntity.ok(pessoaService.update(data));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletePessoa(@RequestParam String id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
