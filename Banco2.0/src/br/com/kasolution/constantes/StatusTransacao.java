package br.com.kasolution.constantes;

public enum StatusTransacao {

	SUCESSO("Transa��o realizada!"),
	VALOR_INCORRETO("Valor informado incorreto!"),
	SALDO_INSUFICIENTE("O cliente n�o possui saldo!"),
	DATA_MATURIDADE_MENOR("A data de maturidade n�o foi atingida!");
	
	private String informacao;
	
	private StatusTransacao(String informacao) {
		this.informacao = informacao;
	}
	
	public String getInformacao() {
		return informacao;
	}
}
