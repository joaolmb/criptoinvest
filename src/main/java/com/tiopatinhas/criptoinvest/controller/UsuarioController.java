package com.tiopatinhas.criptoinvest.controller;

import com.tiopatinhas.criptoinvest.dto.UsuarioDTO;
import com.tiopatinhas.criptoinvest.model.CriptoAtivo;
import com.tiopatinhas.criptoinvest.model.Usuario;
import com.tiopatinhas.criptoinvest.model.PerfilInvestimento;
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

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

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
}
