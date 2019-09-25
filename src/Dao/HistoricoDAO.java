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
		
		String SQL = "insert into historico (data, preco, horas) values (?, ?, ?)"; // Os ? são parâmetros para o sql
		
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getData()); // Ele seta o parâmetro do primeiro ?
		ps.setFloat(2, _objeto.getPreco());
		ps.setDouble(3, _objeto.getHoras());
		ps.execute(); // Executa a query
		
	}

	@Override
	public List<Historico> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Historico> historico = new ArrayList<Historico>();
		ResultSet rs = null;
		
		String SQL = "select data, preco, horas from historico";
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery(); // Retorna um ResultSet com os resultados diferentemente do execute() que retorna apenas booleano
		
		while(rs.next()) { // Percorre a tabela enquanto tiverem registros
			// Caso tenham 5 historicos cadastradoss, esse while rodará 5 vezes (No caso nessa query)
			Historico h = new Historico();
			
			// Configurando os atributos da pessoa a ser adicionada a lista
			
			
			String data = rs.getString(1);
			
			
			
			h.setData(rs.getString(1));
			h.setPreco(rs.getFloat(2));
			h.setHoras(rs.getDouble(3));
			
			/* Get baseado no tipo da coluna (getint, getstring) e o inteiro é o número da coluna na query,*/
			
			ClienteDAO daoCli = new ClienteDAO(this.conexao);
			List<Cliente>cliente = daoCli.listarClientePorHistorico(data);
			h.setCliente(cliente);
			
			CarroDAO daoCar = new CarroDAO(this.conexao);
			List<Carro>carro = daoCar.listarCarroPorHistorico(data);
			h.setCarro(carro);
			
			VagaDAO daoVag = new VagaDAO(this.conexao);
			List<Vaga>vaga = daoVag.listarVagaPorHistorico(data);// Implementar método
			h.setVaga(vaga);
			
			FuncionarioDAO daoFunc = new FuncionarioDAO(this.conexao);
			List<Funcionario>funcionario = daoFunc.listarFuncionarioPorHistorico(data);// Implementar metodo listarCarroPorCliente
			h.setFuncionario(funcionario);
			
			
			historico.add(h); // o historico é adicionada a lista de historicos
		}
		
		return historico;
		
		
	}

	

	@Override
	public Boolean Excluir(int _data) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean rs = false;
		
		String SQL = "delete from historico where data=?";

				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _data);
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornará um valor booleano
		return rs; 
	
	}

	@Override
	public Boolean Atualizar(Historico _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean rs = false;
		
		String SQL = "update historico set data=?, preco=?, horas=? where data=?";
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		

		
		
		ps.setString(1, _objeto.getData());
		ps.setFloat(2, _objeto.getPreco());
		ps.setDouble(3, _objeto.getHoras());
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornará um valor booleano
		
		return rs;
		
	
	}

	@Override
	public Historico buscarPorData(String _data) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = null;
		
		String SQL = "Select * from historico where data=?"; // Com base no id passado por parâmetro ele vai encontrar a pessoa
				
		java.sql.PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _data); // Faz a substituição do ? pelo id passado por parâmetro
		// É utilizado o prepared statement ao invés da concatenação dos parâmetros por questão de segurança
		rs = ps.executeQuery();
		

		
		if(rs.next()) {
			Historico h = new Historico();
			String data = rs.getString(1);
			 
			h.setData(data); 
			h.setPreco(rs.getFloat(2)); 
			h.setHoras(rs.getDouble(3));
			
			ClienteDAO daoCli = new ClienteDAO(this.conexao);
			List<Cliente>cliente = daoCli.listarClientePorHistorico(data);
			
			CarroDAO daoCar = new CarroDAO(this.conexao);
			List<Carro>carro = daoCar.listarCarroPorHistorico(data);
			
			VagaDAO daoVag = new VagaDAO(this.conexao);
			List<Vaga>vaga = daoVag.listarVagaPorHistorico(data);
			
			FuncionarioDAO daoFunc = new FuncionarioDAO(this.conexao);
			List<Funcionario>funcionario = daoFunc.listarFuncionarioPorHistorico(data);
			
			return h; // Ao encotrar o historico
		}
		
		return null;
	}
		
	


}
