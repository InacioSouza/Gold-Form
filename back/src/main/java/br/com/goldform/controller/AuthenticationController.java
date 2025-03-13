package br.com.goldform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goldform.controller.dto.LoginResponseDTO;
import br.com.goldform.controller.form.AuthenticationFORM;
import br.com.goldform.repository.UsuarioRepository;
import br.com.goldform.repository.entity.Usuario;
import br.com.goldform.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository usuarioRepo;

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
}
