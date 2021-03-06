package br.com.solid.srp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.solid.srp.solucao.TipoPessoaSRP;

enum TipoPessoa{
	PessoaFisica("PF", 1),
	PessoaJurida("PJ",2);
	
	private int codigo;
	private String descricao;
	
	 TipoPessoa(String descricao,int codigo){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	 public int getCodigo(){
		 return this.codigo;
	 }
	
	 public String getDescricao(){
		 return this.descricao;
	 }
	
}

public class Pessoa {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private Date dtCadastro;
	private TipoPessoaSRP tipoPessoa;
	private String cpf;
	
	public static boolean IsEmailValido(String pEmail){
		boolean retorno = false;
		
		if(pEmail.contains("@")){
			retorno = true;
		}
		
		return retorno;
	}
	
	public static boolean IsCPFValido(String pCPF){
		boolean retorno = false;
		
		if(pCPF.length() == 11){
			retorno = true;
		}
		
		return retorno;
	}
	
	public boolean IncluirPessoa(Pessoa pPessoa) throws Exception{
		
		if(!Pessoa.IsEmailValido(pPessoa.getEmail())){
			throw new Exception("Email Invalido!!!");
		}
		if(!Pessoa.IsCPFValido(pPessoa.cpf)){
			throw new Exception("CPF Invalido!!!");
		}
		
		Connection conexao = null;
		
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

	
	
	//Gets and Sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public TipoPessoaSRP getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoaSRP tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
