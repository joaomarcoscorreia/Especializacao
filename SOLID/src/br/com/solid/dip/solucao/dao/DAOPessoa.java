package br.com.solid.dip.solucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.solid.dip.ConnectionFactory;
import br.com.solid.dip.base.Pessoa;
import br.com.solid.dip.solucao.interfaces.IDAO;

public class DAOPessoa implements IDAO {

	@Override
	public void incluir(Pessoa pessoa) throws SQLException {

		Connection conexao = ConnectionFactory.createConnection();
		
		StringBuilder st = new StringBuilder();
		st.append("INSERT INTO PESSOA(NOME,TELEFONE,CPF,EMAIL,TIPOPESSOA)");
		st.append("VALUES('");
		st.append(pessoa.getNome());
		st.append("',");
		st.append(pessoa.getTelefone());
		st.append("','");
		st.append(pessoa.getCpf());
		st.append("',");
		st.append(pessoa.getEmail());
		st.append("','");
		st.append(pessoa.getNome());
		st.append("',");
		st.append(pessoa.getTipoPessoa().getCodigo());
		st.append("')");
		
		PreparedStatement ps = conexao.prepareStatement(st.toString());
		
		ps.execute();

	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object consultarChavePrimaria() {
		// TODO Auto-generated method stub
		return new Object();
	}

	@Override
	public Object consultar(String filtro) {
		// TODO Auto-generated method stub
		return new Object();
	}

}
