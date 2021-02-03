package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;

@WebServlet(name = "Armazem", urlPatterns = { "/Controller", "/produtos", "/editar", "/atualizar",
		"/deletar", "/adicionar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO pd = new ProdutoDAO();
	private Produto produto = new Produto();
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/produtos")) {
			redirect(request, response);
		} else if (action.equals("/adicionar")) {
			produto.setNome(request.getParameter("nome"));
			produto.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
			produto.setPreco(Double.valueOf(request.getParameter("preco")));
			pd.adicionarProduto(produto);
			redirect(request, response);
		} else if (action.equals("/editar")) {
			produto = pd.selecionarProduto(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("editar.jsp").forward(request, response);
		} else if (action.equals("/atualizar")) {
			produto.setId(Integer.valueOf(request.getParameter("id")));
			produto.setNome(request.getParameter("nome"));
			produto.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
			produto.setPreco(Double.valueOf(request.getParameter("preco")));
			pd.atualizarProduto(produto);
			redirect(request, response);
		} else if (action.equals("/deletar")) {
			pd.deletarProduto(Integer.valueOf(request.getParameter("id")));
			redirect(request, response);
		}
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Produto> list = pd.selecionarTodos();
		request.setAttribute("produto", list);
		request.getRequestDispatcher("produtos.jsp").forward(request, response);
	}
}
