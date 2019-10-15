package br.com.simvago;

public enum TipoCliente {

	REGULAR, 
	REWARDS;

	public static TipoCliente from(String pedido) {
		if (pedido.contains(REWARDS.name())) {
			return REWARDS;
		}
		return REGULAR;
	}
}
