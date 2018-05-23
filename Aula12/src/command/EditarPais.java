package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class EditarPais implements Command {

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

		cs.criar(pais);
		ArrayList<Pais> lista = new ArrayList<>();
		lista.add(pais);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("AlterarPais.jsp");		
		
		view.forward(request, response);

	}

	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getPaisId() == pais.getPaisId()) {
				return i;
			}
		}
		return -1;
	}
}
