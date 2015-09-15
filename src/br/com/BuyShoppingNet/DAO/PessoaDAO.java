package br.com.BuyShoppingNet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.BuyShoppingNet.VO.Pessoa;


public class PessoaDAO {
	public void inserirPessoa(Pessoa objPessoa) {

		String sqlInsercao = "insert into pessoa(Login, Nome, Senha, ConfirmaSenha, Email, ConfirmaEmail, Cpf, ConfirmaCPF) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		Connection objCon = null;
		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlInsercao);
			pstm.setString(1, objPessoa.getLogin());
			pstm.setString(2, objPessoa.getNome());
			pstm.setString(3, objPessoa.getSenha());
			pstm.setString(4, objPessoa.getConfirmaSenha());
			pstm.setString(5, objPessoa.getEmail());
			pstm.setString(6, objPessoa.getConfirmaEmail());
			pstm.setString(7, objPessoa.getCpf());
			pstm.setString(8, objPessoa.getConfirmaCPF());
			pstm.executeUpdate();
			System.out.println("Insercao Feita Com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na insercao!\nMotivo: " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}
	}
	
	public void excluirPessoa(String nome) {
		String sqlExclusao = "delete from pessoa where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;

		try {
			objCon = ConexaoDAO.getConnection();
			PreparedStatement st = objCon.prepareStatement(sqlExclusao);
			st.setString(1, nome);
			st.executeUpdate();
			System.out.println("Exclusao Feita com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na exclusao do Usuario!\nMotivo: "
					+ e.getMessage());
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}
	}
	
	public void alterarPessoa(Pessoa objPessoa) {
		String sqlAtualizacao = "update pessoa set Nome = ?, Senha = ?, ConfirmaSenha = ?, Email = ?, ConfirmaEmail = ?, Cpf = ?, ConfirmaCPF = ? where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;

		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlAtualizacao);
			pstm.setString(1, objPessoa.getNome());
			pstm.setString(2, objPessoa.getSenha());
			pstm.setString(3, objPessoa.getConfirmaSenha());
			pstm.setString(4, objPessoa.getEmail());
			pstm.setString(5, objPessoa.getConfirmaEmail());
			pstm.setString(6, objPessoa.getCpf());
			pstm.setString(7, objPessoa.getConfirmaCPF());
			pstm.setString(3, objPessoa.getLogin());
			pstm.executeUpdate();
			System.out.println("Atualizacao Feita com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na atualizacao do Usuario");
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}

	}
	/*
	public void excluirPessoa(Pessoa ObjPessoa) {
		String sqlExclusao = "delete from tbUsuario where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;

		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlExclusao);
			pstm.setString(1, ObjPessoa.get);
			pstm.executeUpdate();
			System.out.println("Exclusao Feita com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na exclusao do Usuario!\nMotivo: "
					+ e.getMessage());
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}

	}
*/
	public Pessoa consultarPessoa(String login) {
		Pessoa objUsuario = new Pessoa();
		String sqlConsulta = "select login, Nome, Senha from pessoa where login =  ?";
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;

		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlConsulta);
			pstm.setString(1, login);
			rs = pstm.executeQuery();
			rs.next();
			if (rs.getRow() == 0) {
				objUsuario = null;
				System.out.println("Usuario não consta na base de dados!");
			} else {
				objUsuario.setLogin(rs.getString("login"));
				objUsuario.setNome(rs.getString("nome"));
				objUsuario.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta do Usuario!\nMotivo: "
					+ e.getMessage());
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, rs);
		}
		return objUsuario;
	}
	
	/**
	 *  * Retorna a lista de Pessoa usando lista
	 * @return Lista de Pessoa 
	 * */
	public List<Pessoa> listarPessoa() {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;
		
		
		String sqlListar = "select Login, Nome, Senha, ConfirmaSenha, Email, ConfirmaEmail, Cpf, ConfirmaCPF from pessoa";
		try {
			objCon = ConexaoDAO.getConnection();
			Statement st = objCon.createStatement();
			rs = st.executeQuery(sqlListar);
			
			while (rs.next()) {
				
				Pessoa pessoa=new Pessoa();
				pessoa.setLogin(rs.getString("Login"));
				pessoa.setNome(rs.getString("Nome"));
				pessoa.setSenha(rs.getString("Senha"));
				pessoa.setConfirmaSenha(rs.getString("ConfirmaSenha"));
				pessoa.setEmail(rs.getString("Email"));
				pessoa.setConfirmaEmail(rs.getString("confirmaEmail"));
				pessoa.setCpf(rs.getString("Cpf"));
				pessoa.setConfirmaCPF(rs.getString("ConfirmaCPF"));
				pessoas.add(pessoa);			
			}
			
			

		} catch (Exception e) {
			System.out.println("Erro na listagem de Usuarios");
		} finally {
			ConexaoDAO.closeConnection(null, null, null);
		}
		return pessoas;
	}
	/**
	 *  * Retorna a lista de Pessoa usando ResultSet
	 * @return Lista de Pessoa 
	 * */
	public ResultSet listarPessoas() {
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;

		String sqlListar = "select Login, Nome, Senha, ConfirmaSenha, Email, ConfirmaEmail, Cpf, ConfirmaCPF from pessoa";
		try {
			objCon = ConexaoDAO.getConnection();
			Statement st = objCon.createStatement();
			rs = st.executeQuery(sqlListar);

		} catch (Exception e) {
			System.out.println("Erro na listagem de Usuarios");
		} finally {
			ConexaoDAO.closeConnection(null, null, null);
		}
		return rs;
	}

}
