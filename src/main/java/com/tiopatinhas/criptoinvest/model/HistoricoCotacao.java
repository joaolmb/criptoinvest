package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class HistoricoCotacao {
    @Id @GeneratedValue
    private Long id;
    private LocalDateTime data;
    private BigDecimal cotacao;

    @ManyToOne
    private CriptoAtivo criptoativo;
}
