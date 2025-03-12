package br.com.goldform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.goldform.controller.form.UsuarioFORM;
import br.com.goldform.service.UsuarioService;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioFORM usuarioForm) {
		return this.service.cadastrar(usuarioForm);
	}

}
