package br.com.goldform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goldform.controller.form.UsuarioFORM;
import br.com.goldform.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioFORM usuarioForm) {

		return this.service.cadastrar(usuarioForm);
	}

}
