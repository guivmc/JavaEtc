package br.com.kasolution.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;

import br.com.kasolution.constantes.StatusTransacao;

import static br.com.kasolution.util.Util.*;

public abstract class Conta implements Arquivavel
{
	private static int ultimoCodigo;
	
	private int codigo;
	private String numero;
	private LocalDate dataAbertura;
	private double saldo;

	public Conta() {
		this.codigo = ++ultimoCodigo;
	}
	
	public Conta(String numero, LocalDate dataAbertura) {
		this();
		this.numero = numero;
		this.dataAbertura = dataAbertura;
	}
	
	public Conta(String numero, LocalDate dataAbertura, double saldo) {
		this(numero, dataAbertura);
		this.saldo = saldo;
	}
	
	
	@Override
	public void geraArquivo() 
	{
		File nomeArq = new File(Arquivavel.CAMINHO_BASE + "conta_" + this.codigo + ".txt");
		
		try
		{
		
			System.setOut(new PrintStream(nomeArq));
			System.out.println("Test");
		}
		catch(FileNotFoundException e)
		{
			System.out.println( e.getMessage());
		}
		finally
		{
			System.out.close();
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("#Conta: ").append(codigo)
				.append("\nNúmero: ").append(numero)
				.append("\nData abertura: ")
				.append(formata(dataAbertura))
				.append("\nSaldo: ")
				.append(formata(saldo));
		return sb.toString();
	}
	
	public boolean deposita(double valor) {
		if (valor > 0) {
			saldo += valor;
			return true;
		} else {
			return false;
		}
	}//fim deposita
	
	
	//metodo abstrato saca
	public abstract StatusTransacao saca(double valor);
	

}










