package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {

	public void adicionarProduto(Produto produto) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstm = con.prepareStatement("INSERT INTO produtos (nome, quantidade, preco) VALUES(?, ?, ?)");
			pstm.setString(1, produto.getNome());
			pstm.setInt(2, produto.getQuantidade());
			pstm.setDouble(3, produto.getPreco());
			pstm.execute();
			con.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> selecionarTodos() {
		List<Produto> list = new ArrayList<>();
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM produtos");
			ResultSet r = pstm.executeQuery();
			while (r.next()) {
				Produto produto = new Produto();
				produto.setId(r.getInt("id"));
				produto.setNome(r.getString("nome"));
				produto.setQuantidade(r.getInt("quantidade"));
				produto.setPreco(r.getDouble("preco"));
				list.add(produto);
			}
			con.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Produto selecionarProduto(int id) {
		Produto produto = new Produto();
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			pstm.setInt(1, id);
			ResultSet r = pstm.executeQuery();
			while (r.next()) {
				produto.setId(r.getInt("id"));
				produto.setNome(r.getString("nome"));
				produto.setQuantidade(r.getInt("quantidade"));
				produto.setPreco(r.getDouble("preco"));
			}
			con.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	public void atualizarProduto(Produto produto) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstm = con.prepareStatement("UPDATE produtos SET nome = ?, quantidade = ?, preco = ? WHERE id = ?");
			pstm.setInt(4, produto.getId());
			pstm.setString(1, produto.getNome());
			pstm.setInt(2, produto.getQuantidade());
			pstm.setDouble(3, produto.getPreco());
			pstm.executeUpdate();
			con.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarProduto(int id) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstm = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
			pstm.setInt(1, id);
			pstm.executeUpdate();
			con.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
