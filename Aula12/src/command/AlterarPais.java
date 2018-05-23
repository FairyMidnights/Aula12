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

public class AlterarPais implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String PaisId = request.getParameter("PaisId");
		String PaisNome = request.getParameter("PaisNome");
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

		cs.atualizar(pais);
		@SuppressWarnings("unchecked")
		ArrayList<Pais> lista = (ArrayList<Pais>) session
				.getAttribute("lista");
		int pos = busca(pais, lista);
		lista.remove(pos);
		lista.add(pos, pais);
		session.setAttribute("lista", lista);
		request.setAttribute("cliente", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

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