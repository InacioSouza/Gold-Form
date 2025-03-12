package br.com.goldform.controller.dto;

import br.com.goldform.repository.entity.Endereco;

public record EnderecoDTO(Integer id, String cep, String bairro, String rua, Integer numero, String complemento,
		CidadeDTO cidade) {

	public EnderecoDTO(Endereco endereco) {
		this(endereco.getId(), endereco.getCep(), endereco.getBairro(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), new CidadeDTO(endereco.getCidade()));
	}

}
