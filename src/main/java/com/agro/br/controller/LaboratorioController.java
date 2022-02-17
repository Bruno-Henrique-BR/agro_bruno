package com.agro.br.controller;

import com.agro.br.model.Laboratorio;
import com.agro.br.service.LaboratorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Proprietario")
public class LaboratorioController {
    @Autowired
    private LaboratorioService laboratorioService;


    @GetMapping("/laboratoriosByProprietario/[{id}")
    public ResponseEntity<Collection<Laboratorio>> listaLaboratorio(Long id){
        Collection<Laboratorio> laboratorios = laboratorioService.getLaboratorioByProprietario(id);
        return ResponseEntity.ok(laboratorios);
    }


    @GetMapping("/laboratorio/{id}")
    public ResponseEntity<Laboratorio> Laboratorio(@PathVariable Long id){
        return laboratorioService.getByLaboratorio(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/laboratorio")
    public ResponseEntity<Laboratorio> create(@RequestBody @Valid Laboratorio laboratorio) {
        laboratorio = laboratorioService.createLaboratorio(laboratorio);
        return new ResponseEntity<>(laboratorio, HttpStatus.CREATED);
    }

    @PutMapping("/laboratorio/{id}")
    public ResponseEntity<Laboratorio> update(@PathVariable Long id, @RequestBody @Valid Laboratorio laboratorio) {
        laboratorio = laboratorioService.updateLaboratorio(laboratorio);
        return new ResponseEntity<>(laboratorio, HttpStatus.CREATED);
    }

    @DeleteMapping("/laboratorio/{id}")
    public ResponseEntity<Laboratorio> delete(@PathVariable Long id) {
        laboratorioService.deletarLaboratorio(id);
        return ResponseEntity.noContent().build();
    }
}
