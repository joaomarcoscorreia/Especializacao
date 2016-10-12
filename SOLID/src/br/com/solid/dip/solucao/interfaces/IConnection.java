package br.com.solid.dip.solucao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {

	public Connection createConnection() throws SQLException;
}
