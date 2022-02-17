package com.agro.br.repository;

import com.agro.br.model.Laboratorio;
import com.agro.br.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
    Laboratorio findById(long id);
    Laboratorio deleteById(long id);

    @Query(value = "SELECT * FROM LABORATORIO WHERE laboratorio.proprietario = ?1 ", nativeQuery = true)
    Collection<Laboratorio> getLaboratorioByProprietario(long id);
}
