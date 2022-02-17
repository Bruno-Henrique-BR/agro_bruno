package com.agro.br.service;

import com.agro.br.model.Proprietario;
import com.agro.br.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProprietarioServiceImpl implements  ProprietarioService{

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Override
    public List<Proprietario> listaProprietario() throws RuntimeException {
        return proprietarioRepository.findAll();

    }
    @Override
    public Proprietario createProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @Override
    public Proprietario updateProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @Override
    public void deletarProprietario(Long id) {
        proprietarioRepository.deleteById(id);
    }

    @Override
    public Optional<Proprietario> getByProprietario(Long id) {
        return proprietarioRepository.findById(id);
    }
}
