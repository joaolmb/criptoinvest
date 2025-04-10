package com.tiopatinhas.criptoinvest.controller;

import com.tiopatinhas.criptoinvest.model.PerfilInvestimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class PerfilInvestimentoController {
    // --- Controller do Perfil de Investimento ---

    @PostMapping("/{usuarioId}/perfis")
    public ResponseEntity<PerfilInvestimento> criarPerfil(@PathVariable Long usuarioId, @RequestBody PerfilInvestimento perfil) {
        return ResponseEntity.ok(perfilInvestimentoService.criarPerfil(usuarioId, perfil));
    }

    @GetMapping("/{usuarioId}/perfis")
    public ResponseEntity<List<PerfilInvestimento>> listarPerfisPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(perfilInvestimentoService.listarPerfisPorUsuario(usuarioId));
    }

    @GetMapping("/perfis/{perfilId}")
    public ResponseEntity<PerfilInvestimento> buscarPerfilPorId(@PathVariable Long perfilId) {
        return perfilInvestimentoService.buscarPorId(perfilId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/perfis/{perfilId}")
    public ResponseEntity<Void> removerPerfil(@PathVariable Long perfilId) {
        perfilInvestimentoService.removerPerfil(perfilId);
        return ResponseEntity.noContent().build();
    }
}
