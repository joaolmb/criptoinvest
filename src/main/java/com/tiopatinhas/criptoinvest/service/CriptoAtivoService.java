package com.tiopatinhas.criptoinvest.service;

import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import com.tiopatinhas.criptoinvest.repository.CriptoAtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriptoAtivoService {

    private final CriptoAtivoRepository criptoAtivoRepository;

    @Autowired
    public CriptoAtivoService(CriptoAtivoRepository criptoAtivoRepository) {
        this.criptoAtivoRepository = criptoAtivoRepository;
    }

    public CriptoAtivo criarCriptoAtivo(CriptoAtivo criptoAtivo) {
        return criptoAtivoRepository.save(criptoAtivo);
    }

    public List<CriptoAtivo> listarTodos() {
        return criptoAtivoRepository.findAll();
    }

    public Optional<CriptoAtivo> buscarPorId(Long id) {
        return criptoAtivoRepository.findById(id);
    }

    public void removerCriptoAtivo(Long id) {
        if (!criptoAtivoRepository.existsById(id)) {
            throw new IllegalArgumentException("CriptoAtivo não encontrado");
        }
        criptoAtivoRepository.deleteById(id);
    }

    /*public CriptoAtivo atualizarCriptoAtivo(Long id, CriptoAtivo dadosAtualizados) {
        CriptoAtivo existente = criptoAtivoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CriptoAtivo não encontrado"));

        existente.setNome(dadosAtualizados.getNome());
        existente.setSimbolo(dadosAtualizados.getSimbolo());
        existente.setValorAtual(dadosAtualizados.getValorAtual());

        return criptoAtivoRepository.save(existente);
    }*/
}
