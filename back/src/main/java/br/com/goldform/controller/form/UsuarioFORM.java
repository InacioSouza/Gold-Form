package br.com.goldform.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioFORM(@NotBlank String nome, @NotNull Integer idade, @NotBlank String email, @NotBlank String senha,
		@NotNull EnderecoFORM endereco) {

}
