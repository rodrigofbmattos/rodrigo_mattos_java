package br.edu.infnet.rodrigo_mattos_java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.rodrigo_mattos_java.exceptions.ClienteNaoEncontradoException;
import br.edu.infnet.rodrigo_mattos_java.exceptions.PedidoNaoEncontradoException;
import br.edu.infnet.rodrigo_mattos_java.exceptions.VeiculoNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	@ExceptionHandler(VeiculoNaoEncontradoException.class)
	public ResponseEntity<Object> handleValidationExceptions(VeiculoNaoEncontradoException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<Object> handleValidationExceptions(ClienteNaoEncontradoException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PedidoNaoEncontradoException.class)
	public ResponseEntity<Object> handleValidationExceptions(PedidoNaoEncontradoException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
