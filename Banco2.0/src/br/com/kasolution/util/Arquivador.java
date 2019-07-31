package br.com.kasolution.util;

import br.com.kasolution.dominio.Arquivavel;

public class Arquivador
{
	public static void arquiva(Arquivavel arquivavel)
	{
		arquivavel.geraArquivo();
	}
}
