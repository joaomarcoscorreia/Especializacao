package br.com.solid.ocp.solucao;

import java.math.BigDecimal;

public class ContaCorrente extends DebitoConta {

	@Override
	public String Debitar(BigDecimal pValor, String conta) {
		
		
		
		// Logica para Debitar na Conta Corrente

		return getCodigoTransacao();
	}

}
