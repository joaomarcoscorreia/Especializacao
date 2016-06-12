package br.com.solid.srp.solucao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOPessoaSRP {

public boolean IncluirPessoa(PessoaSRP pPessoa) throws Exception{
		
	/**
	 * Valida alguns atributos 
	 */
		ValidarPessoaSRP.ValidarEmail(pPessoa.getEmail());
		ValidarPessoaSRP.ValidarCPF(pPessoa.getCpf());
		
		Connection conexao = ConnectionFactory.createConnection();
		
		StringBuilder st = new StringBuilder();
		st.append("INSERT INTO PESSOA(NOME,TELEFONE,CPF,EMAIL,TIPOPESSOA)");
		st.append("VALUES('");
		st.append(pPessoa.getNome());
		st.append("',");
		st.append(pPessoa.getTelefone());
		st.append("','");
		st.append(pPessoa.getCpf());
		st.append("',");
		st.append(pPessoa.getEmail());
		st.append("','");
		st.append(pPessoa.getNome());
		st.append("',");
		st.append(pPessoa.getTipoPessoa().getCodigo());
		st.append("')");
		
		PreparedStatement ps = conexao.prepareStatement(st.toString());
		
		return ps.execute();
		
	}
}
