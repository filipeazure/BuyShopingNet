package br.com.BuyShoppingNet.CONTROLE;

//Eshoper
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BuyShoppingNet.DAO.PessoaDAO;
import br.com.BuyShoppingNet.VO.Pessoa;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao.equals("inserir")) {
			RequestDispatcher direcionador;
			String login = request.getParameter("Login");
			String nome = request.getParameter("Nome");
			String senha = request.getParameter("Senha");
			String confirmasenha = request.getParameter("ConfirmaSenha");
			String email = request.getParameter("Email");
			String confirmaemail = request.getParameter("ConfirmaEmail");
			String cpf = request.getParameter("Cpf");
			String confirmacpf = request.getParameter("ConfirmaCpf");

		
			Pessoa pessoa = new Pessoa(login, nome, senha, confirmasenha,
					email, confirmaemail, cpf, confirmacpf);
			PessoaDAO pessoaDAO = new PessoaDAO();
			if (senha.equalsIgnoreCase(confirmasenha)
					&& email.equalsIgnoreCase(confirmaemail)
					&& cpf.equalsIgnoreCase(confirmacpf)) {

				// VERIFICAR SE EEXISTE O CPF NO BANCO DE DADOS

				/*if (pessoa.getLogin().trim().equals(login.trim())
						&& pessoa.getCpf().trim().equals(cpf.trim())) {

					request.setAttribute("mensagem2", "CPF já existe !");
					direcionador = request.getRequestDispatcher("login.jsp");
					direcionador.forward(request, response);

				}

				else {
*/
					pessoaDAO.inserirPessoa(pessoa);

					direcionador = request.getRequestDispatcher("index.html");
					direcionador.forward(request, response);

				//}
			} else if (!senha.equals(confirmasenha)) {
				request.setAttribute("mensagem2",
						"Senha nao pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);

			} else if (!email.equals(confirmaemail)) {
				request.setAttribute("mensagem2",
						"Email não pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);

			} else if (!cpf.equals(confirmacpf)) {
				request.setAttribute("mensagem2",
						"CPF não pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);

			} else if (!senha.equals(confirmasenha)
					&& !email.equals(confirmaemail)) {
				request.setAttribute("mensagem2",
						"Senha e Email não pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);

			} else if (!senha.equals(confirmasenha) && !cpf.equals(confirmacpf)) {
				request.setAttribute("mensagem2",
						"Senha e Cpf não pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);
			} else if (!cpf.equals(confirmacpf) && !email.equals(confirmaemail)) {
				request.setAttribute("mensagem2",
						"Email e Cpf não pode ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);
			} else if (!senha.equals(confirmasenha)
					&& !email.equals(confirmaemail) && !cpf.equals(confirmacpf)) {
				request.setAttribute("mensagem2",
						"Senha, Email e CPF não podem ser diferente !");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);
			}
		}

		else if (acao.equals("excluir")) {
			String login = request.getParameter("login");
			Pessoa pessoa = new Pessoa();
			pessoa.setLogin(login);
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			
			pessoaDAO.excluirPessoa(pessoa.getLogin());
			
			request.getSession(true).setAttribute("lista",
					 pessoaDAO.listarPessoa());
			RequestDispatcher direcionador = request.getRequestDispatcher("ListarConta.jsp");
			direcionador.forward(request, response);

		} else if (acao.equals("listar")) {

			PessoaDAO usuarioDAO = new PessoaDAO();

			request.getSession(true).setAttribute("lista",
					usuarioDAO.listarPessoa());

			RequestDispatcher direcionador = request
					.getRequestDispatcher("home.jsp");
			direcionador.forward(request, response);

		} else if (acao.equals("alterar")) {
			String login = request.getParameter("Login");
			String nome = request.getParameter("Nome");
			String senha = request.getParameter("Senha");
			String confirmasenha = request.getParameter("ConfirmaSenha");
			String email = request.getParameter("Email");
			String confirmaemail = request.getParameter("ConfirmaEmail");
			String cpf = request.getParameter("Cpf");
			String confirmacpf = request.getParameter("ConfirmaCpf");

			// Validar login e senha

			Pessoa pessoa = new Pessoa(login, nome, senha, confirmasenha,
					email, confirmaemail, cpf, confirmacpf);
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.alterarPessoa(pessoa);

			RequestDispatcher direcionador = request
					.getRequestDispatcher("index.html");
			direcionador.forward(request, response);
		} else if (acao.equals("autenticar")) {
			// Recuperando os parametros
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			// Validar login e senha
			PessoaDAO usuarioDAO = new PessoaDAO();

			Pessoa usuario = usuarioDAO.consultarPessoa(login);
			RequestDispatcher direcionador;

			if (usuario != null
					&& usuario.getSenha().trim().equals(senha.trim())) {
				// Setando o usuário da sessao
				request.getSession(true).setAttribute("usuarioOK", usuario);
				direcionador = request.getRequestDispatcher("index.html");
				direcionador.forward(request, response);
			} else {
				request.setAttribute("mensagem", "Login e/ou senha inválidos!");
				direcionador = request.getRequestDispatcher("login.jsp");
				direcionador.forward(request, response);

			}

		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao.equals("listar")) {

			PessoaDAO usuarioDAO = new PessoaDAO();

			request.getSession(true).setAttribute("lista",
					usuarioDAO.listarPessoa());

			RequestDispatcher direcionador = request
					.getRequestDispatcher("ListarConta.jsp");

			direcionador.forward(request, response);
		} else if (acao.equals("excluir")) {
			doPost(request, response);
		}

	}

}
