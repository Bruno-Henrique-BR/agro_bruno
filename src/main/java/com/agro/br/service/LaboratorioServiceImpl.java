package com.agro.br.service;

import com.agro.br.model.Laboratorio;
import com.agro.br.model.Proprietario;
import com.agro.br.repository.LaboratorioRepository;
import com.agro.br.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service

public class LaboratorioServiceImpl implements  LaboratorioService{

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;


    @Override
    public List<Proprietario> listaLaboratorio(Long id) {
        return proprietarioRepository.findAllById(Collections.singleton(id));
    }
    @Override
    public Collection<Laboratorio> getLaboratorioByProprietario(Long id) {
        return laboratorioRepository.getLaboratorioByProprietario(id);
    }

    @Override
    public Laboratorio createLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public Laboratorio updateLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public void deletarLaboratorio(Long id) {
        laboratorioRepository.deleteById(id);
    }

    @Override
    public Optional<Laboratorio> getByLaboratorio(Long id) {
        return laboratorioRepository.findById(id);
    }
}
