package br.com.igordev.despesas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igordev.despesas.dao.JdbcDespesaDao;
import br.com.igordev.despesas.modelo.Despesa;

@Controller
public class OlaMundoController 
{
	
	@RequestMapping("/olaMundoSpring")
	public String execute()
	{
		System.out.println("aaaaaaaaaaaaaaaaaaaa");
		return "ok";
	}
	
	
}
