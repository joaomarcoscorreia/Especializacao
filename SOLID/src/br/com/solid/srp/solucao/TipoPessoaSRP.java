package br.com.solid.srp.solucao;

public enum TipoPessoaSRP {
	PessoaFisica("PF", 1),
	PessoaJurida("PJ",2);
	
	private int codigo;
	private String descricao;
	
	 TipoPessoaSRP(String descricao,int codigo){
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
