package br.com.solid.dip.solucao.interfaces;

import java.sql.SQLException;

import br.com.solid.dip.base.Pessoa;

public interface IDAO {

	void incluir(Pessoa pessoa)throws SQLException;
	void alterar()throws SQLException;
	void excluir()throws SQLException;
	Object consultarChavePrimaria()throws SQLException;
	Object consultar(String filtro)throws SQLException;
}
