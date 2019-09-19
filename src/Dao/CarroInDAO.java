package Dao;

import java.sql.SQLException;
import java.util.List;

import Model.Carro;
import Model.Cliente;

public interface CarroInDAO {

	void Inserir(Carro _objeto) throws SQLException;
	
	List<Carro> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Carro _objeto) throws SQLException;
	
	Carro buscarPorId(int _id) throws SQLException;

	List<Carro> listarCarroPorHistorico(int _idCarro) throws SQLException;
	
	
}