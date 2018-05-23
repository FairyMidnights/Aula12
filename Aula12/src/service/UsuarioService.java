package service;

import model.Pais;
import model.Usuario;

import java.util.ArrayList;

import dao.UsuarioDAO;

public class UsuarioService {
	
	public boolean validar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}

	public ArrayList<Pais> listarPais(String chave) {
		
		return null;
	}
}