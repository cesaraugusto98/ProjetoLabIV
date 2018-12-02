package com.projetolab4.model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class MovimentoSaida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesId;

    @ManyToOne
    @JoinColumn(name = "VEN_ID", nullable = false)
    private Venda venId;

    @Column(name = "MES_DATA")
    private LocalDateTime mesData;

    @Column(name = "MES_DESCRICAO")
    private String mesDescricao;
}
