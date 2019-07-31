package br.com.kasolution.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Banco implements Arquivavel
{
	
	//2 - declarar a variavel instance do mesmo tipo da classe
	private static final Banco instance = new Banco();

	private String nome;
	private ArrayList<Cliente> clientes;
	
	//1 - colocar o construtor privado
	private Banco() {
		clientes = new ArrayList<>();
	}
	
	//3 - método get para pegar a instancia
	public static Banco getInstance() {
		return instance;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Banco: ")
				.append(nome)
				.append("\nRelação de Clientes: ");
		for (Cliente c : clientes) {
			sb.append("\n").append(c);
		}
		return sb.toString();
	}
	
	public void adiciona(Cliente cliente) {
		if (!clientes.contains(cliente) ) {
			clientes.add(cliente);
		} else {
			System.out.println("Já é cliente!");
		}
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}
