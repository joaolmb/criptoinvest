package com.tiopatinhas.criptoinvest.controller;

import com.tiopatinhas.criptoinvest.dto.UsuarioDTO;
import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import com.tiopatinhas.criptoinvest.model.Usuario;
import com.tiopatinhas.criptoinvest.model.PerfilInvestimento;
import com.tiopatinhas.criptoinvest.model.Carteira;
import com.tiopatinhas.criptoinvest.service.UsuarioService;
import com.tiopatinhas.criptoinvest.service.PerfilInvestimentoService;
import com.tiopatinhas.criptoinvest.service.CarteiraService;
import com.tiopatinhas.criptoinvest.service.CriptoAtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;
    private final PerfilInvestimentoService perfilInvestimentoService;
    private final CarteiraService carteiraService;
    private final CriptoAtivoService criptoAtivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenhaHash(dto.getSenha()); // será criptografada no service
        usuario.setAutenticacaoDoisFatores(dto.getAutenticacaoDoisFatores());
        usuario.setTipoUsuario(dto.getTipoUsuario());

        Usuario salvo = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(salvo);
    }

    @Autowired
    public UsuarioController(UsuarioService usuarioService,
                             PerfilInvestimentoService perfilInvestimentoService,
                             CarteiraService carteiraService,
                             CriptoAtivoService criptoAtivoService) {
        this.usuarioService = usuarioService;
        this.perfilInvestimentoService = perfilInvestimentoService;
        this.carteiraService = carteiraService;
        this.criptoAtivoService = criptoAtivoService;
    }

    /*@PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }*/

    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticar(@RequestParam String email, @RequestParam String senha) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioService.autenticar(email, senha));
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(401).build());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    // --- Controller do Perfil de Investimento ---

    /*@PostMapping("/{usuarioId}/perfis")
    public ResponseEntity<PerfilInvestimento> criarPerfil(@PathVariable Long usuarioId, @RequestBody PerfilInvestimento perfil) {
        return ResponseEntity.ok(perfilInvestimentoService.criarPerfil(usuarioId, perfil));
    }

    @GetMapping("/{usuarioId}/perfis")
    public ResponseEntity<List<PerfilInvestimento>> listarPerfisPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(perfilInvestimentoService.listarPerfisPorUsuario(usuarioId));
    }*/

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

    // --- Controller da Carteira ---

    /*@PostMapping("/perfis/{perfilId}/carteiras")
    public ResponseEntity<Carteira> criarCarteira(@PathVariable Long perfilId, @RequestBody Carteira carteira) {
        return ResponseEntity.ok(carteiraService.criarCarteira(perfilId, carteira));
    }

    @GetMapping("/perfis/{perfilId}/carteiras")
    public ResponseEntity<List<Carteira>> listarCarteirasPorPerfil(@PathVariable Long perfilId) {
        return ResponseEntity.ok(carteiraService.listarCarteirasPorPerfil(perfilId));
    }
*/
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

    // --- Controller do CriptoAtivo ---
/*
    @PostMapping("/carteiras/{carteiraId}/criptoativos")
    public ResponseEntity<CriptoAtivo> adicionarCriptoAtivo(@PathVariable Long carteiraId, @RequestBody CriptoAtivo criptoAtivo) {
        return ResponseEntity.ok(criptoAtivoService.adicionarCriptoAtivo(carteiraId, criptoAtivo));
    }

    @GetMapping("/carteiras/{carteiraId}/criptoativos")
    public ResponseEntity<List<CriptoAtivo>> listarPorCarteira(@PathVariable Long carteiraId) {
        return ResponseEntity.ok(criptoAtivoService.listarPorCarteira(carteiraId));
    }
*/
    @GetMapping("/criptoativos/{id}")
    public ResponseEntity<CriptoAtivo> buscarCriptoAtivoPorId(@PathVariable Long id) {
        return criptoAtivoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
/*
    @DeleteMapping("/criptoativos/{id}")
    public ResponseEntity<Void> removerCriptoAtivo(@PathVariable Long id) {
        criptoAtivoService.remover(id);
        return ResponseEntity.noContent().build();
    }
    */
}
