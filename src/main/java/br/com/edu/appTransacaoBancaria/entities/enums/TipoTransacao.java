package br.com.edu.appTransacaoBancaria.entities.enums;

public enum TipoTransacao {

	DEPOSITAR(1, "Depositar"),
	SACAR(2, "Sacar"),
	APLICAR(3, "Aplicar"),
	RESGATAR(4, "Resgatar");
	
	private int cod;
	private String descricao;
	
	private TipoTransacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoTransacao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoTransacao x : TipoTransacao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo inválido: " + cod);
	}
	
	
}
