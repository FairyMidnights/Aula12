package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT UNome, USenha FROM Usuario "
				+ "WHERE UNome = ? and USenha = ?";
		
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getUNome());
				stm.setString(2, usuario.getUSenha());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
}
