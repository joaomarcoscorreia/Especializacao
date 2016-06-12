package br.com.solid.ocp;

import java.math.BigDecimal;

public class DebitoConta {

	public void Debitar(BigDecimal pValor, String pConta, TipoConta pTipoConta){
		
		if(pTipoConta.getCodigo() == TipoConta.ContaCorrente.getCodigo()){
			//Realiza o processamento para debitar de uma conta corrente
		}
		
		
		if(pTipoConta.getCodigo() == TipoConta.ContaPoupanca.getCodigo()){
			//realiza calculos de juros
			//Realiza o processamento para debitar de uma conta Poupanca
		}
		//Necessidade de adiconar outro tipo de conta para ser debitado e agora?
	}
}
