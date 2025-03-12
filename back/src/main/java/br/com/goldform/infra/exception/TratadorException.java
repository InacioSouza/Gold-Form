package br.com.goldform.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorException {

	@ExceptionHandler(RegistroEncontradoException.class)
	public ResponseEntity<?> tratarErroRegistroEncontrado(RegistroEncontradoException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}
}
