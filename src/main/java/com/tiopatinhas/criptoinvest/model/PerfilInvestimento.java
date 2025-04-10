package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PerfilInvestimento {
    @Id @GeneratedValue
    private Long id;
    private String nomePerfil;
    private String tipoPerfil;

    @ManyToOne
    private Usuario usuario;

    @OneToOne(mappedBy = "perfil")
    private Carteira carteira;

    @OneToMany(mappedBy = "perfil")
    private List<Transacao> transacoes;

    @OneToMany(mappedBy = "perfil")
    private List<RelatorioInvestimento> relatorios;
}
