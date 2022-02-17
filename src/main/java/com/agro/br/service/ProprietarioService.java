package com.agro.br.service;

import com.agro.br.model.Proprietario;

import java.util.List;
import java.util.Optional;

public interface ProprietarioService {
    List<Proprietario> listaProprietario();
    Optional<Proprietario> getByProprietario(Long id);
    Proprietario createProprietario(Proprietario proprietario);
    Proprietario updateProprietario(Proprietario proprietario);
    void deletarProprietario(Long id);
}
