package br.com.goldform.controller.dto;

import br.com.goldform.repository.entity.Estado;

public record EstadoDTO(Integer id, String nome, String uf) {

	public EstadoDTO(Estado estado) {
		this(estado.getId(), estado.getNome(), estado.getUf());
	}

}
