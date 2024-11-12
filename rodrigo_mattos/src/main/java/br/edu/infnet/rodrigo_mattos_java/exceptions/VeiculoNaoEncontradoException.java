package br.edu.infnet.rodrigo_mattos_java.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public VeiculoNaoEncontradoException(String message) {
		super(message); 
	}
}
