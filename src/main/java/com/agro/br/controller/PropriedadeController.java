package com.agro.br.controller;

import com.agro.br.model.Laboratorio;
import com.agro.br.model.Propriedade;
import com.agro.br.service.LaboratorioService;
import com.agro.br.service.PropriedadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Proprietario")
public class PropriedadeController {
    @Autowired
    private PropriedadeService propriedadeService;


    @GetMapping("/propriedades")
    public ResponseEntity<List<Propriedade>> Propriedade(){
        List<Propriedade> propriedades = propriedadeService.listaPropriedade();
        return ResponseEntity.ok(propriedades);
    }

    @GetMapping("/Propriedade/{id}")
    public ResponseEntity<Propriedade> Propriedade(@PathVariable Long id){
        return propriedadeService.getByPropriedade(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/propriedade")
    public ResponseEntity<Propriedade> create(@RequestBody @Valid Propriedade propriedade) {
        propriedade = propriedadeService.createPropriedade(propriedade);
        return new ResponseEntity<>(propriedade, HttpStatus.CREATED);
    }

    @PutMapping("/propriedade/{id}")
    public ResponseEntity<Propriedade> update(@PathVariable Long id, @RequestBody @Valid Propriedade propriedade) {
        propriedade = propriedadeService.updatePropriedade(propriedade);
        return new ResponseEntity<>(propriedade, HttpStatus.CREATED);
    }

    @DeleteMapping("/propriedade/{id}")
    public ResponseEntity<Propriedade> delete(@PathVariable Long id) {
        propriedadeService.deletarPropriedade(id);
        return ResponseEntity.noContent().build();
    }
}
