package com.tiopatinhas.criptoinvest.controller;

import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CriptoAtivoController {
    // --- Controller do CriptoAtivo ---

    @PostMapping("/carteiras/{carteiraId}/criptoativos")
    public ResponseEntity<CriptoAtivo> adicionarCriptoAtivo(@PathVariable Long carteiraId, @RequestBody CriptoAtivo criptoAtivo) {
        return ResponseEntity.ok(criptoAtivoService.adicionarCriptoAtivo(carteiraId, criptoAtivo));
    }

    @GetMapping("/carteiras/{carteiraId}/criptoativos")
    public ResponseEntity<List<CriptoAtivo>> listarPorCarteira(@PathVariable Long carteiraId) {
        return ResponseEntity.ok(criptoAtivoService.listarPorCarteira(carteiraId));
    }
    @GetMapping("/criptoativos/{id}")
    public ResponseEntity<CriptoAtivo> buscarCriptoAtivoPorId(@PathVariable Long id) {
        return criptoAtivoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/criptoativos/{id}")
    public ResponseEntity<Void> removerCriptoAtivo(@PathVariable Long id) {
        criptoAtivoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
