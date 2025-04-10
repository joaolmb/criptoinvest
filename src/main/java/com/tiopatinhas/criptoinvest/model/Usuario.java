package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private Boolean autenticacaoDoisFatores;
    private String tipoUsuario;

    // Relacionamento
    @OneToMany(mappedBy = "usuario")
    private List<PerfilInvestimento> perfis;
}
