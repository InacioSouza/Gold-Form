package br.com.goldform.controller.form;

import jakarta.validation.constraints.NotBlank;

public record EstadoFORM(@NotBlank String nome, @NotBlank String uf) {

}
