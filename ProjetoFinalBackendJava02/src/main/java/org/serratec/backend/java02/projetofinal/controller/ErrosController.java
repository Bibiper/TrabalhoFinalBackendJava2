package org.serratec.backend.java02.projetofinal.controller;

import org.serratec.backend.java02.projetofinal.exceptions.ContaInvalida;
import org.serratec.backend.java02.projetofinal.exceptions.ValorInvalido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrosController {
	@ExceptionHandler(ContaInvalida.class)
	public ResponseEntity<String> trataContaInvalida(ContaInvalida exception){
		String msg = "Essa conta não existe";
		return ResponseEntity.notFound()
				.header("x.erro.msg", msg)
				.build();
	}
	
	@ExceptionHandler(ValorInvalido.class)
	public ResponseEntity<String> trataValorInvalido(ValorInvalido exception){
		String msg = "Esse valor não é válido";
		return ResponseEntity.notFound()
				.header("x.erro.msg", msg)
				.build();
	}
}
