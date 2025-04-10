package com.tiopatinhas.criptoinvest.repository;

import com.tiopatinhas.criptoinvest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
