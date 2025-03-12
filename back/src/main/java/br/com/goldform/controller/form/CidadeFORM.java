package br.com.goldform.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CidadeFORM(@NotBlank String nome, @NotNull EstadoFORM estado) {

}
