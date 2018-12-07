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

    @ManyToOne
    private Produto proId;

    @ManyToOne
    private Venda venId;

    @Column(name = "QTD_PRO")
    private Integer qtdPro;
}
