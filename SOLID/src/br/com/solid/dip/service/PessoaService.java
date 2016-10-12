package br.com.solid.dip.service;

import java.sql.SQLException;

import br.com.solid.dip.base.Pessoa;
import br.com.solid.dip.solucao.interfaces.ICPF;
import br.com.solid.dip.solucao.interfaces.IDAO;
import br.com.solid.dip.solucao.interfaces.IEmail;

public class PessoaService {

	private IDAO daoPessoa;
	private IEmail emailValidar;
	private ICPF cpfValidar;
	
	public PessoaService(IDAO dao, IEmail emailValidar,ICPF cpfValidar){
		this.daoPessoa = dao;
		this.emailValidar = emailValidar;
		this.cpfValidar = cpfValidar;
	}
	
	public void incluir(Pessoa pessoa)throws SQLException{
		cpfValidar.validarCPF();
		daoPessoa.incluir(pessoa);
		emailValidar.validarEMAIL();
	}
}
