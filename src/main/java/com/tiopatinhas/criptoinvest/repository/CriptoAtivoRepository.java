package com.tiopatinhas.criptoinvest.repository;

import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CriptoAtivoRepository extends JpaRepository<CriptoAtivo, Long> {
    Optional<CriptoAtivo> findBySimbolo(String simbolo);
}
