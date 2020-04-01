package br.com.cadastro.funcionario.controller;

import br.com.cadastro.funcionario.model.Funcionario;
import br.com.cadastro.funcionario.service.FuncionarioService;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;
import com.totvs.tjf.api.context.v1.request.ApiFieldRequest;
import com.totvs.tjf.api.context.v1.request.ApiPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/f1")
@ApiGuideline(ApiGuidelineVersion.v1)
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<?> obterListaDeFuncionarios(ApiPageRequest apiPage, ApiFieldRequest apiFieldRequest) {
        return ResponseEntity.ok(this.funcionarioService.obterListaDeFuncionarios(apiPage, apiFieldRequest));
    }

    @GetMapping("/funcionario")
    public ResponseEntity<?> obterFuncionarioDetalhado(ApiFieldRequest field, Funcionario simpleFilter) {
        return ResponseEntity.ok(this.funcionarioService.obterFuncionarioDetalhado(field, simpleFilter));
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario, UriComponentsBuilder uriBuilder) {
        Funcionario funcionarioSalvo = this.funcionarioService.cadastrarFuncionario(funcionario);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(funcionarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionarioSalvo);
    }

}
