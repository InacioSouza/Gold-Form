package br.com.goldform.infra.exception;

public class RegistroEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegistroEncontradoException(String mensagem) {
		super(mensagem);
	}

}
