package br.com.solid.ocp.solucao;

import java.math.BigDecimal;

public abstract class DebitoConta {

	public String codigoTransacao;
	
	public abstract String Debitar(BigDecimal pValor, String conta);

	public String getCodigoTransacao() {
		return codigoTransacao;
	}

	
	
}
