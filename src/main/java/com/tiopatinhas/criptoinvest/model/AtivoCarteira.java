package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class AtivoCarteira {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal quantidade;
    private BigDecimal valorDeCompra;
    private LocalDateTime dataCompra;

    @ManyToOne
    private CriptoAtivo criptoativo;

    @ManyToOne
    private Carteira carteira;
}
