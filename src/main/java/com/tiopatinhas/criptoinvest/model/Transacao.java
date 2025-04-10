package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id @GeneratedValue
    private Long id;
    private String tipoTransacao;
    private LocalDateTime data;
    private BigDecimal quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne
    private CriptoAtivo criptoativo;

    @ManyToOne
    private PerfilInvestimento perfil;
}
