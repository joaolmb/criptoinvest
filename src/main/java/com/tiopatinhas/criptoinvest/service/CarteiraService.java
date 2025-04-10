package com.tiopatinhas.criptoinvest.service;

import com.tiopatinhas.criptoinvest.model.Carteira;
import com.tiopatinhas.criptoinvest.model.PerfilInvestimento;
import com.tiopatinhas.criptoinvest.repository.CarteiraRepository;
import com.tiopatinhas.criptoinvest.repository.PerfilInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final PerfilInvestimentoRepository perfilRepository;

    @Autowired
    public CarteiraService(CarteiraRepository carteiraRepository, PerfilInvestimentoRepository perfilRepository) {
        this.carteiraRepository = carteiraRepository;
        this.perfilRepository = perfilRepository;
    }

    /*public Carteira criarOuRecuperarCarteira(Long perfilId) {
        return carteiraRepository.findByPerfilId(perfilId)
                .orElseGet(() -> {
                    PerfilInvestimento perfil = perfilRepository.findById(perfilId)
                            .orElseThrow(() -> new IllegalArgumentException("Perfil de investimento não encontrado"));
                    Carteira novaCarteira = new Carteira();
                    novaCarteira.setPerfil(perfil);
                    return carteiraRepository.save(novaCarteira);
                });
    }*/

    public Optional<Carteira> buscarPorId(Long id) {
        return carteiraRepository.findById(id);
    }

    public void removerCarteira(Long id) {
        if (!carteiraRepository.existsById(id)) {
            throw new IllegalArgumentException("Carteira não encontrada");
        }
        carteiraRepository.deleteById(id);
    }

    /*public Carteira atualizarCarteira(Long id, Carteira dadosAtualizados) {
        Carteira existente = carteiraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));

        existente.setSaldoAtual(dadosAtualizados.getSaldoAtual());

        return carteiraRepository.save(existente);
    }*/
}
