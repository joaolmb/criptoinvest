package com.tiopatinhas.criptoinvest.repository;

import com.tiopatinhas.criptoinvest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    Optional<Carteira> findByPerfilId(Long perfilId);
}
