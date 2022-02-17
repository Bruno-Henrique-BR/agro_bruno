package com.agro.br.service;

import com.agro.br.model.Laboratorio;
import com.agro.br.model.Propriedade;

import java.util.List;
import java.util.Optional;

public interface PropriedadeService {
    List<Propriedade> listaPropriedade();
    Optional<Propriedade> getByPropriedade(Long id);
    Propriedade createPropriedade(Propriedade propriedade);
    Propriedade updatePropriedade(Propriedade propriedade);
    void deletarPropriedade(Long id);
}
