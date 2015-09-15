package br.com.BuyShoppingNet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.BuyShoppingNet.VO.Produto;

public class ProdutoDAO {
	public void inserirPessoa(Produto objProduto) {

		String sqlInsercao = "insert into produto(CodProduto,NomeProduto,DataProduto,Medida,Tipo,Quantidade,ValorInicial) values (?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		Connection objCon = null;
		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlInsercao);
			pstm.setString(1, objProduto.getCodProduto());
			pstm.setString(2, objProduto.getNomeProduto());
			pstm.setString(3, objProduto.getDataProduto());
			pstm.setString(4, objProduto.getMedida());
			pstm.setString(5, objProduto.getTipo());
			pstm.setInt(6, objProduto.getQuantidade());
			pstm.setDouble(7, objProduto.getValorInicial());
			pstm.executeUpdate();
			System.out.println("Insercao de produto Feita Com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na insercao de produto!\nMotivo: " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}
	}
	
	public void excluirProduto(String nome) {
		String sqlExclusao = "delete from produto where CodProduto= ?";
		PreparedStatement pstm = null;
		Connection objCon = null;

		try {
			objCon = ConexaoDAO.getConnection();
			PreparedStatement st = objCon.prepareStatement(sqlExclusao);
			st.setString(1, nome);
			st.executeUpdate();
			System.out.println("Exclusao do produto Feita com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na exclusao do produto!\nMotivo: "
					+ e.getMessage());
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, null);
		}
	}
	
	public void alterarProduto(Produto objProduto) {
		String sqlAtualizacao = "update produto set NomeProduto= ?, DataProduto= ?, Medida= ?,Tipo= ?,Quantidade=? ,ValorInicial= ? where CodProduto= ?";
		PreparedStatement pstm = null;
		Connection objCon = null;

		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlAtualizacao);
			pstm.setString(1, objProduto.getNomeProduto());
			pstm.setString(2, objProduto.getDataProduto());
			pstm.setString(3, objProduto.getMedida());
			pstm.setString(4, objProduto.getTipo());
			pstm.setInt(5, objProduto.getQuantidade());
			pstm.setDouble(6, objProduto.getValorInicial());
			pstm.setString(7, objProduto.getCodProduto());
			
			pstm.executeUpdate();
			System.out.println("Atualizacao Feita com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro na atualizacao do Produto");
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
	public Produto consultarPessoa(String CodProduto) {
		Produto objProduto = new Produto();
		String sqlConsulta = "select NomeProduto,DataProduto,Medida,Tipo,Quantidade,ValorInicial from produto where CodProduto =  ?";
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;

		try {
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlConsulta);
			pstm.setString(1, CodProduto);
			rs = pstm.executeQuery();
			rs.next();
			if (rs.getRow() == 0) {
				objProduto = null;
				System.out.println("Produto não consta na base de dados!");
			} else {
				objProduto.setCodProduto(rs.getString("CodProduto"));
				objProduto.setNomeProduto(rs.getString("NomeProduto"));
				objProduto.setDataProduto(rs.getString("DataProduto"));
				objProduto.setMedida(rs.getString("Medida"));
				objProduto.setTipo(rs.getString("Tipo"));
				objProduto.setQuantidade(rs.getInt("Quantidade"));
				objProduto.setValorInicial(rs.getDouble("ValorInicial"));
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta do Produto!\nMotivo: "
					+ e.getMessage());
		} finally {
			ConexaoDAO.closeConnection(objCon, pstm, rs);
		}
		return objProduto;
	}
	
	/**
	 * Retorna um resultset de produtos.
	 * @return ResultSet de produtos
	 */
	public ResultSet listarProdutos() {
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;

		String sqlListar = "select CodProduto,NomeProduto,DataProduto,Medida,Quantidade,ValorInicial from produto";
		try {
			objCon = ConexaoDAO.getConnection();
			Statement st = objCon.createStatement();
			rs = st.executeQuery(sqlListar);

		} catch (Exception e) {
			System.out.println("Erro na listagem de produtos");
		} finally {
			ConexaoDAO.closeConnection(null, null, null);
		}
		return rs;
	}
	
	/**
	 * Retorna a lista de produtos usando lista
	 * @return Lista de produtos 
	 */
	public List<Produto> listarProduto() {
		List<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs = null;

		String sqlListar = "select CodProduto, NomeProduto, DataProduto, Medida, Tipo, Quantidade, ValorInicial from produto";
		try {
			objCon = ConexaoDAO.getConnection();
			Statement st = objCon.createStatement();
			rs = st.executeQuery(sqlListar);
			
			while (rs.next()) {
				Produto produto = new Produto();
				
				produto.setCodProduto(rs.getString("CodProduto"));
				produto.setNomeProduto(rs.getString("NomeProduto"));
				produto.setDataProduto(rs.getString("DataProduto"));
				produto.setMedida(rs.getString("Medida"));
				produto.setTipo(rs.getString("Tipo"));
				produto.setQuantidade(rs.getInt("Quantidade"));
				produto.setValorInicial(rs.getDouble("ValorInicial"));
				
				produtos.add(produto);
			}

		} catch (Exception e) {
			System.out.println("Erro na listagem de produtos");
		} finally {
			ConexaoDAO.closeConnection(null, null, null);
		}
		return produtos;
	}


}
