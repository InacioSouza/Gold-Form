package br.com.goldform.controller.dto;

import br.com.goldform.repository.entity.Usuario;

public record UsuarioDTO(Integer id, String nome, Integer idade, String email, EnderecoDTO endereco) {

	public UsuarioDTO(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getIdade(), usuario.getEmail(),
				new EnderecoDTO(usuario.getEndereco()));
	}

}
