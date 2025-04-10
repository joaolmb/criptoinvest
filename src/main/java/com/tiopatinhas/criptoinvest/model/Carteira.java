package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Carteira {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal saldoTotal;

    @OneToOne
    private PerfilInvestimento perfil;

    @OneToMany(mappedBy = "carteira")
    private List<AtivoCarteira> ativos;
}
