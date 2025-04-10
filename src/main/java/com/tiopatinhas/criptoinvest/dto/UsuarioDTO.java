package com.tiopatinhas.criptoinvest.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private Boolean autenticacaoDoisFatores;
    private String tipoUsuario;
}