package com.kasolution.dao;

import java.util.List;

public interface DAO<T> extends AutoCloseable
{
	public void salvar(T t) throws DAOException;
	public void atualizar(T t) throws DAOException;
	public void excluir(T t) throws DAOException;
	public T buscarId(int id) throws DAOException;
	public List<T> buscarTodos() throws DAOException;
	public void close() throws DAOException;
}
