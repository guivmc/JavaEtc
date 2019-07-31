package br.com.kasolution.dominio;

import java.time.LocalDate;

import br.com.kasolution.constantes.StatusTransacao;

import static br.com.kasolution.util.Util.*;

public class ContaCorrente extends Conta {

	private double limiteEspecial;

	public ContaCorrente() {
	}

	public ContaCorrente(String numero, LocalDate dataAbertura, double limiteEspecial) {
		super(numero, dataAbertura);
		this.limiteEspecial = limiteEspecial;
	}

	public ContaCorrente(String numero, LocalDate dataAbertura, double saldo, double limiteEspecial) {
		super(numero, dataAbertura, saldo);
		this.limiteEspecial = limiteEspecial;
	}

	public double getLimiteEspecial() {
		return limiteEspecial;
	}

	public void setLimiteEspecial(double limiteEspecial) {
		this.limiteEspecial = limiteEspecial;
	}

	@Override
	public String toString() {
		String info = super.toString();
		info += "\nLimite Especial: " + formata(limiteEspecial);
		return info;
	}

	@Override
	public StatusTransacao saca(double valor) {
		if (valor <= 0) {
			return StatusTransacao.VALOR_INCORRETO;
		} else {
			double saldoTotal = getSaldo() + limiteEspecial;
			if (saldoTotal >= valor) {
				setSaldo(getSaldo() - valor);
				return StatusTransacao.SUCESSO;
			} else {
				return StatusTransacao.SALDO_INSUFICIENTE;
			} // fim if
		} // fim if
	}// fim saca
}// fim classe







