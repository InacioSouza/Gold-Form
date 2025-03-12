package br.com.goldform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.goldform.controller.form.UsuarioFORM;
import br.com.goldform.infra.exception.RegistroEncontradoException;
import br.com.goldform.repository.EnderecoRepository;
import br.com.goldform.repository.UsuarioRepository;
import br.com.goldform.repository.entity.Endereco;
import br.com.goldform.repository.entity.Usuario;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;

	@Transactional
	public ResponseEntity<?> cadastrar(UsuarioFORM usuarioForm) {

		if (usuarioRepo.existsByEmail(usuarioForm.email())) {
			throw new RegistroEncontradoException("Usuário já cadastrado!");
		}

		Endereco endereco;

		if (enderecoRepo.enderecoCadastrado(usuarioForm.endereco().cep(), usuarioForm.endereco().numero())) {
			endereco = enderecoRepo.findByCepAndNumero();
		} else {
			endereco = new Endereco(usuarioForm.endereco());
			endereco = enderecoRepo.save(endereco);
		}

		Usuario usuario = new Usuario(usuarioForm);
		usuario = usuarioRepo.save(usuario);

		return ResponseEntity.ok(usuario);
	}
}
