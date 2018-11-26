package com.projetolab4.model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class MovimentoSaida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesId;

    @OneToOne
    @Column(name = "VEN_ID")
    private Venda venId;

    @Column(name = "MES_DATA")
    private LocalDateTime mesData;

    @Column(name = "MES_DESCRICAO")
    private String mesDescricao;
}
