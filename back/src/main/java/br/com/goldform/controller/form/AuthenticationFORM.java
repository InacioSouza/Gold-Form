package br.com.goldform.controller.form;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationFORM(@NotBlank String email, @NotBlank String senha) {

}
