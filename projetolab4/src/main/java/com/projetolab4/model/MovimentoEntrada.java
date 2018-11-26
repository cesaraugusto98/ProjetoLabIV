package com.projetolab4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MES_MOVIMENTO_ENTRADA")
public class MovimentoEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MET_ID", nullable = false)
    private Long metId;

    @OneToOne
    @Column(name = "FOR_ID")
    private Fornecedor forId;

    @OneToMany
    @Column(name = "PRO_ID")
    private Produto prodId;

    @Column(name = "MES_QTD")
    private Long metQtd;

    @Column(name = "MES_DATA")
    private LocalDateTime metData;

    @Column(name = "MES_DESCRICAO")
    @Size(max = 30)
    private String metDescricao;
}
