package br.com.solid.ocp;

public enum TipoConta {

	ContaCorrente(1,"Conta Corrente"),
	ContaPoupanca(2, "Conta Poupanca");
	
	private int codigo;
	private String descricao;
	
	TipoConta(int codigo, String descricao){
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
