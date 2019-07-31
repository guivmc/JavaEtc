package br.com.kasolution.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import static br.com.kasolution.util.Util.*;

public class Cliente implements Arquivavel
{

	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	
	public Cliente() {
	}

	public Cliente(String cpf, String nome, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public void geraArquivo() 
	{
		File nomeArq = new File(Arquivavel.CAMINHO_BASE + this.nome + ".txt");
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		String info = "CPF.: " + cpf;
		info += " Nome: " + nome;
		info += " Data Nascimento: " + formata(dataNascimento);
		return info;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cliente) {
			Cliente cliente = (Cliente) obj;
			if (this.cpf.equals(cliente.cpf)) {
				return true;
			}
		}
		return false;
	}
}






