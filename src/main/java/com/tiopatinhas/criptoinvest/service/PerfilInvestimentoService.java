package com.tiopatinhas.criptoinvest.service;

import com.tiopatinhas.criptoinvest.model.PerfilInvestimento;
import com.tiopatinhas.criptoinvest.model.Usuario;
import com.tiopatinhas.criptoinvest.repository.PerfilInvestimentoRepository;
import com.tiopatinhas.criptoinvest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilInvestimentoService {

    private final PerfilInvestimentoRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PerfilInvestimentoService(PerfilInvestimentoRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /*public PerfilInvestimento criarPerfil(Long usuarioId, PerfilInvestimento perfil) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        perfil.setUsuario(usuario);
        return perfilRepository.save(perfil);
    }*/

    /*public List<PerfilInvestimento> listarPerfisPorUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .map(Usuario::getPerfis)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }*/

    public Optional<PerfilInvestimento> buscarPorId(Long id) {
        return perfilRepository.findById(id);
    }

    public void removerPerfil(Long id) {
        if (!perfilRepository.existsById(id)) {
            throw new IllegalArgumentException("Perfil de investimento não encontrado");
        }
        perfilRepository.deleteById(id);
    }

    /*public PerfilInvestimento atualizarPerfil(Long id, PerfilInvestimento dadosAtualizados) {
        PerfilInvestimento existente = perfilRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Perfil de investimento não encontrado"));

        existente.setNome(dadosAtualizados.getNome());
        existente.setCnpj(dadosAtualizados.getCnpj());

        return perfilRepository.save(existente);
    }*/
}
