package br.com.goldform.controller.dto;

import br.com.goldform.repository.entity.Cidade;

public record CidadeDTO(Integer id, String nome, EstadoDTO estado) {

	public CidadeDTO(Cidade cidade) {
		this(cidade.getId(), cidade.getNome(), new EstadoDTO(cidade.getEstado()));
	}

}
