package Control;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.CarroDAO;
import Model.Carro;
import Conexao.FabricaConexao;

/**
 * Servlet implementation class ListarCarrosServlet
 */
@WebServlet("/ListarCarrosServlet")
public class ListarCarrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCarrosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			CarroDAO dao = new CarroDAO(conexao);
			
			List<Carro> listaCarros = dao.listarTodos();
			request.setAttribute("listaCarros", listaCarros);
			   
			RequestDispatcher despachante = request.getRequestDispatcher("/ListarCarros.jsp");
			despachante.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}