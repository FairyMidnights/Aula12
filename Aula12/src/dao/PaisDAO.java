package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO {
	
	public int criar(Pais pais) {
		String sqlInsert = "INSERT INTO Pais(PaisNome, PaisPopulacao, PaisArea) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getPaisNome());
			stm.setLong(2, pais.getPaisPopulacao());
			stm.setDouble(3, pais.getPaisArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setPaisId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getPaisId();
	}

	public void atualizar(Pais pais) {
		String sqlUpdate = "UPDATE Pais SET PaisNome =?, PaisPopulacao=?, PaisArea=? WHERE PaisId=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getPaisNome());
			stm.setLong(2, pais.getPaisPopulacao());
			stm.setDouble(3, pais.getPaisArea());
			stm.setInt(4, pais.getPaisId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM Pais WHERE PaisId = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pais carregar(int id) {
		Pais pais = new Pais();
		pais.setPaisId(id);
		String sqlSelect = "SELECT PaisNome, PaisPopulacao, PaisArea FROM Pais WHERE pais.id = ?";
	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getPaisId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setPaisNome(rs.getString("PaisNome"));
					pais.setPaisPopulacao(rs.getLong("PaisPopulacao"));
					pais.setPaisArea(rs.getDouble("PaisArea"));
				} else {
					pais.setPaisId(-1);
					pais.setPaisNome(null);
					pais.setPaisPopulacao((Long) null);
					pais.setPaisArea((Double) null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}
}


