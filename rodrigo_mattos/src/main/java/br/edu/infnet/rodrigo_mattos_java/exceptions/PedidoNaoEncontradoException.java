package br.edu.infnet.rodrigo_mattos_java.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PedidoNaoEncontradoException(String message) {
		super(message); 
	}
}
