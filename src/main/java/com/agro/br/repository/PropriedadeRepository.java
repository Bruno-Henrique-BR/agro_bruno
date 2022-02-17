package com.agro.br.repository;

import com.agro.br.model.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
    Propriedade findById(long id);
    Propriedade deleteById(long id);
}
