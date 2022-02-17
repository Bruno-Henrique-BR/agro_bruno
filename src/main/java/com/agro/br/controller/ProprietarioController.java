package com.agro.br.controller;

import com.agro.br.model.Proprietario;
import com.agro.br.service.ProprietarioService;
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
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;


    @ApiOperation(value = "Retorna uma lista de Customers")
    @GetMapping("/proprietarios")
    public ResponseEntity<List<Proprietario>> proprietario(){
        List<Proprietario> proprietarios = proprietarioService.listaProprietario();
        return ResponseEntity.ok(proprietarios);
    }

    @ApiOperation(value = "Consulta um customer")
    @GetMapping("/proprietario/{id}")
    public ResponseEntity<Proprietario> proprietario(@PathVariable Long id){
        return proprietarioService.getByProprietario(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Cria um customer")
    @PostMapping("/proprietario")
    public ResponseEntity<Proprietario> create(@RequestBody @Valid Proprietario proprietario) {
        proprietario = proprietarioService.createProprietario(proprietario);
        return new ResponseEntity<>(proprietario, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um customer")
    @PutMapping("/proprietario/{id}")
    public ResponseEntity<Proprietario> update(@PathVariable Long id, @RequestBody @Valid Proprietario proprietario) {
        proprietario = proprietarioService.updateProprietario(proprietario);
        return new ResponseEntity<>(proprietario, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deleta um customer")
    @DeleteMapping("/proprietario/{id}")
    public ResponseEntity<Proprietario> delete(@PathVariable Long id) {
        proprietarioService.deletarProprietario(id);
        return ResponseEntity.noContent().build();
    }
}
