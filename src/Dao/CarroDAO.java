package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Carro;
import Model.Vaga;



public class CarroDAO implements CarroInDAO {
	
	private Connection conexao = null;
	
	public CarroDAO(Connection _conn) {
		this.conexao = _conn;
	}
	@Override
	public void Inserir(Carro _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO carro (placa, nome) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		Vaga v = new Vaga();
		for(int i = 1; i <= 20; i++) {//Insere em vaga vazia
			
			if(v.isStatus() != true) {
				ps.setString(i, _objeto.getNome());
				ps.setString(i, _objeto.getPlaca());
				break;
			}
		}
		
		ps.execute();
	}

	@Override
	public List<Carro> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Carro> carros = new ArrayList<Carro>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, placa, nome FROM carro";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String placa = rs.getString(2);
			String nome = rs.getString(3);
			
			
			Carro c = new Carro(id, placa, nome);
			
			carros.add(c);
			
			
		}
		
		return carros;
		
		
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM carro WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		Vaga v = new Vaga();//Número Vaga = _id Carro
		v.setStatus(false);
		
		return ps.execute();
		
	}

	@Override
	public Boolean Atualizar(Carro _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "UPDATE carro SET id = ?, placa = ?, nome = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getPlaca());
		ps.setString(3, _objeto.getNome());
		
		
		
		return ps.execute();
		
	}

	@Override
	public Carro buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = null;
		Carro c = null;
		
		String SQL = "SELECT id, placa, nome FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String placa = rs.getString(2);
			String nome = rs.getString(3);
			
			
			c = new Carro(id, placa, nome);
		}
		
		return c;
		
		
	}

}
