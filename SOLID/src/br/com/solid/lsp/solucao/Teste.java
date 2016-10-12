package br.com.solid.lsp.solucao;

public class Teste {

	public static void testCalculo(Retangulo ret){
		
		System.out.println("Calculo da Area do Retangulo");
		System.out.println("Altura: ");
		System.out.println(ret.Altura);
		System.out.println(" Largura: ");
		System.out.println(ret.largura);
		System.out.println(" Area: ");
		System.out.println(ret.CalularAREA());
	}
	
	public static void main(String... args){
		
		Quadrado quad = new Quadrado();
		quad.setAltura(10);
		quad.setLargura(5);
		
		Teste.testCalculo(quad);
	}
}
