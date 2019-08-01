package com.kasolution.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kasolution.domain.Funcionario;

public class FuncionarioDAO implements DAO<Funcionario>
{
	
    private static final String SQL_INSERT = "INSERT INTO FUNCIONARIO (NOME, SALARIO)"
            + " VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE FUNCIONARIO SET "
            + " NOME = ?, "
            + " SALARIO = ? "
            + " WHERE CODIGO = ? ";
    private static final String SQL_DELETE = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";
    private static final String SQL_QUERY_ALL = "SELECT CODIGO, NOME, SALARIO FROM FUNCIONARIO";
    private static final String SQL_QUERY_ONE = "SELECT CODIGO, NOME, SALARIO FROM FUNCIONARIO WHERE CODIGO = ?";

    Connection con;
    
    public FuncionarioDAO()
    {
    	String host = "jdbc:mysql://localhost:3306/HR", username="root", password="";
    	
    	try
    	{
    		this.con = DriverManager.getConnection(host, username, password);
    	}
    	catch(SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}    	
    }
    
	@Override
	public void salvar(Funcionario f) throws DAOException
	{
		try(PreparedStatement stmt = this.con.prepareStatement(this.SQL_INSERT))
		{
			stmt.setString(1, f.getNome());
			stmt.setDouble(2, f.getSalario());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void atualizar(Funcionario f) throws DAOException
	{
		try(PreparedStatement stmt = this.con.prepareStatement(this.SQL_UPDATE))
		{
			stmt.setString(1, f.getNome());
			stmt.setDouble(2, f.getSalario());
			stmt.setInt(3, f.getCodigo());
			
			if(stmt.executeUpdate() != 1)
				throw new DAOException("Retorno diferente de 1");
		}
		catch(SQLException e)
		{
			throw new DAOException(e.getMessage());
		}
		
		
	}

	@Override
	public void excluir(Funcionario f) throws DAOException 
	{
		try(PreparedStatement stmt = this.con.prepareStatement(this.SQL_DELETE))
		{
			stmt.setInt(1, f.getCodigo());
	
			if(stmt.executeUpdate() != 1)
				throw new DAOException("Retorno diferente de 1");
		}
		catch(SQLException e)
		{
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Funcionario buscarId(int id) throws DAOException 
	{
		Funcionario f = null;
		
		try(PreparedStatement stmt = this.con.prepareStatement(this.SQL_QUERY_ONE))
		{
			stmt.setInt(1, id);
			
			try(ResultSet rs = stmt.executeQuery())
			{
				if(rs.next())
					f = ormFuncionario(rs);
			}	
		}
		catch(SQLException e)
		{
			throw new DAOException(e.getMessage());
		}
		return f;
	}

	@Override
	public List<Funcionario> buscarTodos() throws DAOException
	{
		List<Funcionario> f = new ArrayList<>();
		
		try(PreparedStatement stmt = this.con.prepareStatement(this.SQL_QUERY_ALL))
		{
			try(ResultSet rs = stmt.executeQuery())
			{
				while (rs.next())
					f.add(ormFuncionario(rs));
			}	
		}
		catch(SQLException e)
		{
			throw new DAOException(e.getMessage());
		}
		
		return f;
	}

	@Override
	public void close() throws DAOException 
	{
		try
		{
			this.con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}		
	}

	private Funcionario ormFuncionario(ResultSet rs) throws SQLException
	{
		
		return new Funcionario.Builder()
				.codigo(rs.getInt("CODIGO"))
				.nome(rs.getString("NOME"))
				.salario(rs.getDouble("SALARIO"))
				.build();
	}
}
