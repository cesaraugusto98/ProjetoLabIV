package com.projetolab4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITV_ITEM_VENDA")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itvId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRO_ID")
    private Produto produto;

    @JoinColumn(name = "VEN_ID ", nullable = false)
    @ManyToOne
    private Venda venda;

    @Column(name = "QTD_PRO")
    private Integer qtdPro;
}
