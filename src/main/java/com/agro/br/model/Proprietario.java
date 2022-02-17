package com.agro.br.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    
    private String observacoes;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="proprietario_id")
    private List<Propriedade> infosPropriedade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="proprietario_id")
    private List<Laboratorio> laboratorio;




}
