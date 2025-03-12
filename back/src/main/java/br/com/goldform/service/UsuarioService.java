package br.com.goldform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.goldform.controller.dto.UsuarioDTO;
import br.com.goldform.controller.form.UsuarioFORM;
import br.com.goldform.infra.exception.RegistroEncontradoException;
import br.com.goldform.repository.CidadeRepository;
import br.com.goldform.repository.EnderecoRepository;
import br.com.goldform.repository.EstadoRepository;
import br.com.goldform.repository.UsuarioRepository;
import br.com.goldform.repository.entity.Cidade;
import br.com.goldform.repository.entity.Endereco;
import br.com.goldform.repository.entity.Estado;
import br.com.goldform.repository.entity.Usuario;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;

	@Autowired
	private CidadeRepository cidadeRepo;

	@Autowired
	private EstadoRepository estadoRepo;

	@Transactional
	public ResponseEntity<?> cadastrar(UsuarioFORM usuarioForm) {

		if (usuarioRepo.existsByEmail(usuarioForm.email())) {
			throw new RegistroEncontradoException("Usuário já cadastrado!");
		}

		Endereco endereco;

		if (enderecoRepo.enderecoCadastrado(usuarioForm.endereco().cep(), usuarioForm.endereco().numero())) {
			endereco = enderecoRepo.enderecoPorCepENumero(usuarioForm.endereco().cep(),
					usuarioForm.endereco().numero());

		} else {
			endereco = new Endereco(usuarioForm.endereco());

			Cidade cidade;

			if (cidadeRepo.existsByNome(usuarioForm.endereco().cidade().nome())) {
				cidade = cidadeRepo.findByNome(endereco.getCidade().getNome());

			} else {

				cidade = new Cidade();
				cidade.setNome(usuarioForm.endereco().cidade().nome());

				Estado estado;

				if (estadoRepo.existsByNome(usuarioForm.endereco().cidade().estado().nome())) {
					estado = estadoRepo.findByNome(usuarioForm.endereco().cidade().estado().nome());

				} else {
					estado = estadoRepo.save(new Estado(usuarioForm.endereco().cidade().estado()));
				}

				cidade.setEstado(estado);
				cidade = cidadeRepo.save(cidade);

			}

			endereco.setCidade(cidade);
			endereco = enderecoRepo.save(endereco);
		}

		Usuario usuario = new Usuario(usuarioForm);
		usuario.setEndereco(endereco);
		usuario = usuarioRepo.save(usuario);

		UsuarioDTO usuarioSalvoDTO = new UsuarioDTO(usuario);

		return ResponseEntity.ok(usuarioSalvoDTO);
	}
}
