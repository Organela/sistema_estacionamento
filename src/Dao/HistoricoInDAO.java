package Dao;

import java.sql.SQLException;
import java.util.List;

import Model.Historico;

public interface HistoricoInDAO {
	
void Inserir(Historico _objeto) throws SQLException;
	
	List<Historico> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Historico _objeto) throws SQLException;
	
	

	

	Historico buscarPorData(String _data)throws SQLException;
}
