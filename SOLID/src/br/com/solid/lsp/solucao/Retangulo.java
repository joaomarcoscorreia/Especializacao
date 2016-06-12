package br.com.solid.lsp.solucao;

public class Retangulo {

	public double Altura;
	public double largura;
	
	public double CalularAREA(){
		return Altura * largura;
	}

	public double getAltura() {
		return Altura;
	}

	public void setAltura(double altura) {
		Altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	
}
