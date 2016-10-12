package br.com.solid.ocp.solucao;

import java.math.BigDecimal;

public class ContaPoupanca extends DebitoConta {

	@Override
	public String Debitar(BigDecimal pValor, String conta) {
		// Logica de Debitar de uma Poupanca
		return getCodigoTransacao();
	}

}
