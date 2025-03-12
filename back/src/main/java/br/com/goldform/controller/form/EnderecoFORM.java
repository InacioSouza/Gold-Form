package br.com.goldform.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoFORM(@NotBlank String cep, @NotNull CidadeFORM cidade, @NotBlank String bairro, @NotBlank String rua, @NotNull Integer numero, String complemento) {

}
