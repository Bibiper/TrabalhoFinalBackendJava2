package org.serratec.backend.java02.projetofinal.controller;

import java.util.List;

import org.serratec.backend.java02.projetofinal.domain.Conta;
import org.serratec.backend.java02.projetofinal.exceptions.ContaInvalida;
import org.serratec.backend.java02.projetofinal.exceptions.ValorInvalido;
import org.serratec.backend.java02.projetofinal.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/conta")
public class ContaController {
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public List<Conta> ExibirContas(){ 
		return contaService.ExibirContas();
	}
	
	@GetMapping("/{numero}")
	public Conta getConta(@PathVariable Integer numero)throws ContaInvalida {
		return contaService.getConta(numero);
	}
	
	@PutMapping("/{numero}")
	public Conta putConta(@PathVariable Integer numero, @RequestBody Conta conta)throws ContaInvalida {
		return contaService.alteracaoConta(numero, conta);
	}

	@PostMapping
	public Conta postConta(@RequestBody Conta conta) {
		return contaService.inserirConta(conta);
	}
	
	@DeleteMapping("/{numero}")
	public void deletarConta(@PathVariable Integer numero)throws ContaInvalida {
		contaService.deletarConta(numero);
	}
	
	@PostMapping("/{numero}/saque")
	public Conta operacaoConta(@PathVariable Integer numero, @RequestParam Double valor)throws ValorInvalido, ContaInvalida {
		return contaService.saque(numero, valor);
	}	
 
	@PostMapping("/{numero}/deposito")
	public Conta depositoConta(@PathVariable Integer numero, @RequestParam Double valor)throws ValorInvalido, ContaInvalida {
		return contaService.deposito(numero, valor);
	}
}


