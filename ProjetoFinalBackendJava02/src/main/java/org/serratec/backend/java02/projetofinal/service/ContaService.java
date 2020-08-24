package org.serratec.backend.java02.projetofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.java02.projetofinal.domain.Conta;
import org.serratec.backend.java02.projetofinal.exceptions.ContaInvalida;
import org.serratec.backend.java02.projetofinal.exceptions.ValorInvalido;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
		
	private List<Conta> contas = new ArrayList<Conta>();
	
	public ContaService() {
		contas.add(new Conta(12, "José Abreu", 500.00));
		contas.add(new Conta(23, "Maria Júlia", 300.00));
		contas.add(new Conta(15, "João Víctor", 200.00));
		contas.add(new Conta(28, "Alice Santos", 800.00));
		contas.add(new Conta(17, "Carolina Duarte", 1000.00));
	}

	public List<Conta> ExibirContas(){
		return contas;
	}
	
	public Conta getConta(Integer numero) throws ContaInvalida{
		Conta encontrada = null;
		for (Conta conta: contas) {
			if (conta.getNumero().equals(numero)) {
				encontrada = conta;
				break;
			}
		}
	    if (encontrada == null)  {
	    	throw new ContaInvalida();
	    }else {
	    	return encontrada;
	    }
	}
	
	public Conta alteracaoConta (Integer numero, Conta contaAlterada) throws ContaInvalida{
		Conta encontrada = getConta(numero);
		encontrada.setNumero(contaAlterada.getNumero());
		encontrada.setTitular(contaAlterada.getTitular());
		return encontrada;
	}
	
	public Conta inserirConta (Conta contaNova) {
		contas.add(contaNova);
		return contaNova;
	}
	
	public void deletarConta (Integer numero) throws ContaInvalida{
		Conta encontrada = getConta(numero);
		contas.remove(encontrada);
	}
	
	public Conta saque (Integer numero, Double valor) throws ValorInvalido, ContaInvalida{
		Conta encontrada = getConta(numero);
		if (encontrada.getSaldo() < valor) {
			throw new ValorInvalido();
		}else {
			encontrada.setSaldo(encontrada.getSaldo() - valor); 
		}
		return encontrada;	
	}

	public Conta deposito (Integer numero, Double valor) throws ValorInvalido, ContaInvalida {
		Conta encontrada = getConta(numero);
		if (valor < 50) {
			throw new ValorInvalido();
		}else {
			encontrada.setSaldo(encontrada.getSaldo() + valor);
		}		
		return encontrada;
	}
	
}
