package br.com.goldform.controller;

import br.com.goldform.controller.dto.LoginResponseDTO;
import br.com.goldform.controller.form.AuthenticationFORM;
import br.com.goldform.controller.form.UsuarioFORM;
import br.com.goldform.infra.exception.UsuarioJaCadastradoException;
import br.com.goldform.repository.UsuarioRepository;
import br.com.goldform.repository.entity.Usuario;
import br.com.goldform.service.TokenService;
import br.com.goldform.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationFORM dados) {
		System.out.println("CREDENCIAIS: " + dados.email() + " - " + dados.senha());

		var usernamePassword = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((Usuario) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid UsuarioFORM dadosCadastro) {
		if(this.usuarioRepo.findByEmail(dadosCadastro.email()) != null){
			throw new UsuarioJaCadastradoException("O usuário '" + dadosCadastro.nome() + "' já possui cadastro");
		}

		return this.usuarioService.cadastrar(dadosCadastro);
	}
	
}
