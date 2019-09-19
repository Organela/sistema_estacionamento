package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Carro;
import Model.Cliente;
import Model.Funcionario;
import Model.Historico;
import Model.Vaga;

public class HistoricoDAO implements HistoricoInDAO {

	private Connection conexao;
	
	public HistoricoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Historico _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "insert into historico (data, preco) values (?, ?)"; // Os ? são parâmetros para o sql
		
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getData()); // Ele seta o parâmetro do primeiro ?

		ps.execute(); // Executa a query
		
	}

	@Override
	public List<Historico> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Historico> historico = new ArrayList<Historico>();
		ResultSet rs = null;
		
		String SQL = "select id, data, preco from historico";
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery(); // Retorna um ResultSet com os resultados diferentemente do execute() que retorna apenas booleano
		
		while(rs.next()) { // Percorre a tabela enquanto tiverem registros
			// Caso tenham 5 historicos cadastradoss, esse while rodará 5 vezes (No caso nessa query)
			Historico h = new Historico();
			
			// Configurando os atributos da pessoa a ser adicionada a lista
			
			int id = rs.getInt(1);
			String data = rs.getString(2);
		
			h.setId(rs.getInt(1)); 
			h.setData(rs.getString(2));
			h.setPreco(rs.getFloat(3));
			
			// Get baseado no tipo da coluna (getInt, getString) e o inteiro é o número da coluna na query,
			
			ClienteDAO daoCli = new ClienteDAO(this.conexao);
			List<Cliente>cliente = daoCli.listarClientePorHistorico(id);
			h.setCliente(cliente);
			
			CarroDAO daoCar = new CarroDAO(this.conexao);
			List<Carro>carro = daoCar.listarCarroPorHistorico(id);
			h.setCarro(carro);
			
			VagaDAO daoVag = new VagaDAO(this.conexao);
			List<Vaga>vaga = daoVag.listarVagaPorHistorico(id);// Implementar método
			h.setVaga(vaga);
			
			FuncionarioDAO daoFunc = new FuncionarioDAO(this.conexao);
			List<Funcionario>funcionario = daoFunc.listarFuncionarioPorHistorico(id);// Implementar metodo listarCarroPorCliente
			h.setFuncionario(funcionario);
			
			
			historico.add(h); // o historico é adicionada a lista de historicos
		}
		
		return historico;
		
		
	}

	

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean rs = false;
		
		String SQL = "delete from historico where id=?";

				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornará um valor booleano
		return rs; 
	
	}

	@Override
	public Boolean Atualizar(Historico _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean rs = false;
		
		String SQL = "update historico set id=?, data=?, preco=? where id=?";
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		

		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getData());
		ps.setFloat(3, _objeto.getPreco());
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornará um valor booleano
		
		return rs;
		
	
	}

	@Override
	public Historico buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = null;
		
		String SQL = "Select * from historico where id=?"; // Com base no id passado por parâmetro ele vai encontrar a pessoa
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id); // Faz a substituição do ? pelo id passado por parâmetro
		// É utilizado o prepared statement ao invés da concatenação dos parâmetros por questão de segurança
		rs = ps.executeQuery();
		

		
		if(rs.next()) {
			Historico h = new Historico();
			int id = rs.getInt(1);
			h.setId(id); 
			h.setData(rs.getString(2)); 
			h.setPreco(rs.getFloat(3)); 
			
			ClienteDAO daoCli = new ClienteDAO(this.conexao);
			List<Cliente>cliente = daoCli.listarClientePorHistorico(id);
			
			CarroDAO daoCar = new CarroDAO(this.conexao);
			List<Carro>carro = daoCar.listarCarroPorHistorico(id);
			
			VagaDAO daoVag = new VagaDAO(this.conexao);
			List<Vaga>vaga = daoVag.listarVagaPorHistorico(id);
			
			FuncionarioDAO daoFunc = new FuncionarioDAO(this.conexao);
			List<Funcionario>funcionario = daoFunc.listarFuncionarioPorHistorico(id);
			
			return h; // Ao encotrar o historico
		}
		
		return null;
	}
		
	


}
