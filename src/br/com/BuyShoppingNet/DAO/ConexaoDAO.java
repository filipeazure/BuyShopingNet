package br.com.BuyShoppingNet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {
	public static Connection getConnection() {
		// URL de acesso ao banco de dados
		String url = "jdbc:postgresql://127.0.0.1:5432/buyshoppingnet";
		Connection conexao = null;
		try {
			// Carregando o driver JDBC do banco de dados
			Class.forName("org.postgresql.Driver");

			// Estabelecendo a conexao com o banco de dados
			conexao = DriverManager.getConnection(url, "postgres", "935847");

			System.out.println("Conexao realizada com sucesso!");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver não localizado!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}

		// Devolvendo a conexao com o banco de dados
		return conexao;
	}

	public static void closeConnection(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void closeConnection(Connection conn, Statement stmt,
			ResultSet rs, PreparedStatement pstm) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}