package com.tiopatinhas.criptoinvest.controller;

import com.tiopatinhas.criptoinvest.model.Carteira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tiopatinhas.criptoinvest.service.CarteiraService;

import java.util.List;

public class CarteiraController {

    @PostMapping("/perfis/{perfilId}/carteiras")
    public ResponseEntity<Carteira> criarCarteira(@PathVariable Long perfilId, @RequestBody Carteira carteira) {
        return ResponseEntity.ok(carteiraService.criarCarteira(perfilId, carteira));
    }

    @GetMapping("/perfis/{perfilId}/carteiras")
    public ResponseEntity<List<Carteira>> listarCarteirasPorPerfil(@PathVariable Long perfilId) {
        return ResponseEntity.ok(carteiraService.listarCarteirasPorPerfil(perfilId));
    }

    @GetMapping("/carteiras/{carteiraId}")
    public ResponseEntity<Carteira> buscarCarteiraPorId(@PathVariable Long carteiraId) {
        return carteiraService.buscarPorId(carteiraId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/carteiras/{carteiraId}")
    public ResponseEntity<Void> removerCarteira(@PathVariable Long carteiraId) {
        carteiraService.removerCarteira(carteiraId);
        return ResponseEntity.noContent().build();
    }
}

