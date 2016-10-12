package br.com.solid.dip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/Cadastro"; //Nome da base de dados
		String user = "user"; //nome do usuário do MySQL
		String password = "password"; //senha do MySQL
		
		Connection conexao = null;
		conexao = DriverManager.getConnection(url, user, password);
		
		return conexao;
	}
}
