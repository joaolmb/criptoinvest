package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CriptoAtivo {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String simbolo;
    private BigDecimal cotacaoAtual;
    private String descricao;

    @OneToMany(mappedBy = "criptoativo")
    private List<AtivoCarteira> ativos;

    @OneToMany(mappedBy = "criptoativo")
    private List<HistoricoCotacao> historico;
}
