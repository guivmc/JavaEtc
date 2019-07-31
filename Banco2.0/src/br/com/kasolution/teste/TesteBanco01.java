package br.com.kasolution.teste;

import java.time.LocalDate;

import br.com.kasolution.dominio.Banco;
import br.com.kasolution.dominio.Cliente;
import br.com.kasolution.util.Arquivador;

public class TesteBanco01 {

	public static void main(String[] args) {
		Cliente cli01 = new Cliente("217.024.060-83", "Pabllo Vittar",
				LocalDate.of(1994, 11, 1));
		
		Cliente cli02 = new Cliente("217.024.060-83", "Pabllo Vittar",
				LocalDate.of(1994, 11, 1));
		
		System.out.println("Teste de igualdade: ");
		if (cli01.equals(cli02)) {
			System.out.println("igual\n");
		} else {
			System.out.println("diferente\n");
		}		
		
		Banco banco = Banco.getInstance();
		banco.setNome("Santander");
		//adicionar clientes no banco
		banco.adiciona(cli01);
		banco.adiciona(cli02);
		System.out.println(banco);
		
		Arquivador.arquiva(banco);
	}

}





