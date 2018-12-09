package com.projetolab4.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MES_MOVIMENTO_SAIDA")
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
