package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String PaisId = request.getParameter("PaisId");
		String PaisNome = request.getParameter("PaisnNme");
		String PaisPopulacao = request.getParameter("PaisPopulacao");
		String PaisArea = request.getParameter("PaisArea");
		int id = -1;
		try {
			id = Integer.parseInt(PaisId);
		} catch (NumberFormatException e) {

		}

		Pais pais = new Pais();
		pais.setPaisId(PaisId);
		pais.setPaisNome(PaisNome);
		pais.setPaisPopulacao(Long.parseLong(PaisPopulacao));
		pais.setPaisArea(Double.parseDouble(PaisArea));
		PaisService cs = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		

		pais = cs.carregar(pais.getPaisId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

		view.forward(request, response);

	}

}