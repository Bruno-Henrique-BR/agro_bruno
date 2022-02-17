package com.agro.br.service;

import com.agro.br.model.Propriedade;
import com.agro.br.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PropriedadeServiceImpl implements  PropriedadeService{

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Override
    public List<Propriedade> listaPropriedade() throws RuntimeException {
        return propriedadeRepository.findAll();

    }
    @Override
    public Propriedade createPropriedade(Propriedade propriedade) {
        return propriedadeRepository.save(propriedade);
    }

    @Override
    public Propriedade updatePropriedade(Propriedade propriedade) {
        return propriedadeRepository.save(propriedade);
    }

    @Override
    public void deletarPropriedade(Long id) {
        propriedadeRepository.deleteById(id);
    }

    @Override
    public Optional<Propriedade> getByPropriedade(Long id) {
        return propriedadeRepository.findById(id);
    }
}
