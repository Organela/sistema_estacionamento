package Dao;

import java.sql.SQLException;
import java.util.List;

import Model.Cliente;

public interface ClienteInDAO {

	void Inserir(Cliente _objeto) throws SQLException;
	
	List<Cliente> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Cliente _objeto) throws SQLException;
	
	Cliente buscarPorId(int _id) throws SQLException;
	
	List<Cliente> listarClientePorCarro(int _idCliente) throws SQLException;
	
	List<Cliente> listarClientePorHistorico(String data)throws SQLException;
}
