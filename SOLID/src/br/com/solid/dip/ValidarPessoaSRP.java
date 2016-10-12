package br.com.solid.dip;

public class ValidarPessoaSRP {

	
	public static void ValidarEmail(String pEmail) throws Exception{
		
		
		if(pEmail.contains("@")){
			throw new Exception("Email Invalido!!!");
		}
		
		
	}
	
	public static void ValidarCPF(String pCPF) throws Exception{

		
		if(pCPF.length() == 11){
			throw new Exception("CPF Invalido!!!");
		}
		
	
	}
	
	
}
