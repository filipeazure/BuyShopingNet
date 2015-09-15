package br.com.BuyShoppingNet.CONTROLE;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.BuyShoppingNet.DAO.ProdutoDAO;
import br.com.BuyShoppingNet.VO.Produto;


/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		if (acao.equals("inserir")) {
			RequestDispatcher direcionador;

			String codProduto = request.getParameter("CodProduto");
			String nomeProduto = request.getParameter("NomeProduto");
			String dataProduto = request.getParameter("DataProduto");
			String medida = request.getParameter("Medida");
			String tipo = request.getParameter("Tipo");
			int quantidade = Integer.parseInt(request
					.getParameter("Quantidade"));
			double valorInicial = Double.parseDouble(request
					.getParameter("ValorInicial"));

			Produto produto = new Produto(codProduto, dataProduto, nomeProduto,
					medida, tipo, quantidade, valorInicial);

			ProdutoDAO produtoDAO = new ProdutoDAO();

			produtoDAO.inserirPessoa(produto);
			request.getSession(true).setAttribute("lista",
					produtoDAO.listarProduto());

			direcionador = request.getRequestDispatcher("manterproduto.jsp");
			direcionador.forward(request, response);

		}

		else if (acao.equals("excluir")) {
			String codproduto = request.getParameter("codproduto");
			Produto produto = new Produto();
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produto.setCodProduto(codproduto);
			produtoDAO.excluirProduto(produto.getCodProduto());

			request.getSession(true).setAttribute("lista",
					produtoDAO.listarProduto());

			RequestDispatcher direcionador = request
					.getRequestDispatcher("manterproduto.jsp");
			// / pagina que irá enviar apos o cadastro do produto

			direcionador.forward(request, response);

		} else if (acao.equals("listar")) {

			ProdutoDAO produtoDAO = new ProdutoDAO();

			request.getSession(true).setAttribute("lista",
					produtoDAO.listarProduto());
			// request.setAttribute("lista", produtoDAO.listarProduto());
			RequestDispatcher direcionador = request
					.getRequestDispatcher("manterproduto.jsp");
			direcionador.forward(request, response);
		} else if (acao.equals("alterar")) {

			String codProduto = request.getParameter("CodProduto");
			String nomeProduto = request.getParameter("NomeProduto");
			String dataProduto = request.getParameter("DataProduto");
			String medida = request.getParameter("Medida");
			String tipo = request.getParameter("Tipo");
			int quantidade = Integer.parseInt(request
					.getParameter("Quantidade"));
			double valorInicial = Double.parseDouble(request
					.getParameter("ValorInicial"));

			// Validar login e senha

			Produto produto = new Produto(codProduto, dataProduto, nomeProduto,
					medida, tipo, quantidade, valorInicial);
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.alterarProduto(produto);
			RequestDispatcher direcionador = request
					.getRequestDispatcher("index.html");
			direcionador.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao.equals("listar")) {

			ProdutoDAO usuarioDAO = new ProdutoDAO();

			request.getSession(true).setAttribute("lista",
					usuarioDAO.listarProduto());

			RequestDispatcher direcionador = request
					.getRequestDispatcher("manterproduto.jsp");
			direcionador.forward(request, response);
		} else if (acao.equals("excluir")) {
			doPost(request, response);
		}
	}

}
