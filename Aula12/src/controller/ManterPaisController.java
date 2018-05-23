package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController2
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterPaisController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pPaisNome = request.getParameter("PaisNome");
		
		Long pPaisPopulacao = Long.parseLong(request.getParameter("PaisPopulacao"));
		
		Double pPaisArea = Double.parseDouble(request.getParameter("PaisArea"));
		
		
		Pais pais = new Pais();
		pais.setPaisNome(pPaisNome);
		pais.setPaisPopulacao(pPaisPopulacao);
		pais.setPaisArea(pPaisArea);
		
		
		PaisService cs = new PaisService();
		cs.criar(pais);
		pais = cs.carregar(pais.getPaisId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+pais.getPaisId()+"<br>");
		out.println(	"nome: "+pais.getPaisNome()+"<br>");
		out.println(	"populacao: "+pais.getPaisPopulacao()+"<br>");
		out.println(	"area: "+pais.getPaisArea()+"<br>");
	    out.println("</body></html>");
	    
	 
        request.setAttribute("pais", pais);
        
        RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);
		
	}

}