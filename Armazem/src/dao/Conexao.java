package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/armazem?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "senha";
	
	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
