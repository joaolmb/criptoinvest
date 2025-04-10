package com.tiopatinhas.criptoinvest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notificacao {
    @Id @GeneratedValue
    private Long id;
    private String mensagem;
    private LocalDateTime dataEnvio;
    private String tipo;

    @ManyToOne
    private Usuario usuario;
}
