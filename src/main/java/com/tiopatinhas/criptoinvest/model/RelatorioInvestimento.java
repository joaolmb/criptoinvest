package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class RelatorioInvestimento {
    @Id @GeneratedValue
    private Long id;
    private LocalDateTime dataGeracao;
    private BigDecimal retornoTotal;
    private BigDecimal lucroPrejuizo;

    @ManyToOne
    private PerfilInvestimento perfil;
}
