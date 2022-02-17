package com.agro.br.service;

import com.agro.br.model.Laboratorio;
import com.agro.br.model.Proprietario;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LaboratorioService {
    Collection<Laboratorio> getLaboratorioByProprietario(Long id);
    List<Proprietario> listaLaboratorio(Long id);
    Optional<Laboratorio> getByLaboratorio(Long id);
    Laboratorio createLaboratorio(Laboratorio laboratorio);
    Laboratorio updateLaboratorio(Laboratorio laboratorio);
    void deletarLaboratorio(Long id);
}
