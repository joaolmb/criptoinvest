package com.tiopatinhas.criptoinvest.service;

import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import com.tiopatinhas.criptoinvest.model.Transacao;
import com.tiopatinhas.criptoinvest.model.Carteira;
import com.tiopatinhas.criptoinvest.repository.CriptoAtivoRepository;
import com.tiopatinhas.criptoinvest.repository.TransacaoRepository;
import com.tiopatinhas.criptoinvest.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CarteiraRepository carteiraRepository;
    private final CriptoAtivoRepository criptoAtivoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository, CarteiraRepository carteiraRepository, CriptoAtivoRepository criptoAtivoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.carteiraRepository = carteiraRepository;
        this.criptoAtivoRepository = criptoAtivoRepository;
    }

    /*public Transacao registrarTransacao(Long carteiraId, Long criptoAtivoId, Transacao transacao) {
        Carteira carteira = carteiraRepository.findById(carteiraId)
                .orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));

        CriptoAtivo ativo = criptoAtivoRepository.findById(criptoAtivoId)
                .orElseThrow(() -> new IllegalArgumentException("Criptoativo não encontrado"));

        transacao.setCarteira(carteira);
        transacao.setCriptoAtivo(ativo);

        BigDecimal valorTransacao = transacao.getValorUnitario().multiply(BigDecimal.valueOf(transacao.getQuantidade()));

        if (transacao.getTipo().equalsIgnoreCase("COMPRA")) {
            carteira.setSaldoAtual(carteira.getSaldoAtual().subtract(valorTransacao));
        } else if (transacao.getTipo().equalsIgnoreCase("VENDA")) {
            carteira.setSaldoAtual(carteira.getSaldoAtual().add(valorTransacao));
        } else {
            throw new IllegalArgumentException("Tipo de transação inválido. Use 'COMPRA' ou 'VENDA'");
        }

        carteiraRepository.save(carteira);
        return transacaoRepository.save(transacao);
    }*/

    /*public List<Transacao> listarTransacoesPorCarteira(Long carteiraId) {
        return transacaoRepository.findByCarteiraId(carteiraId);
    }*/

    public Optional<Transacao> buscarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public void removerTransacao(Long id) {
        if (!transacaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Transação não encontrada");
        }
        transacaoRepository.deleteById(id);
    }
}
