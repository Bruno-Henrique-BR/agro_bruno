package com.agro.br.repository;

import com.agro.br.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    Proprietario findById(long id);
    Proprietario deleteById(long id);
}
