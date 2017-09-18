package br.com.zgsolucoes

class Carta implements Comparable<Carta> {
	
	char simbolo
	char naipe
	ValorDaCarta valor
	
	Carta(String carta) throws IllegalArgumentException {
		
		char[] cartaAux = carta.toCharArray()
		String simbolosValidos = "23456789TJQKA"
		String naipeValidos = "SHDC"
		
		if (cartaAux.size() > 2 || !simbolosValidos.contains(cartaAux[0].toString()) || !naipeValidos.contains(cartaAux[1].toString()) ) {
			throw new IllegalArgumentException("Carta inserida invalida")
		}
		
		this.simbolo = cartaAux[0]
		this.naipe = cartaAux[1]
		
		valor = ValorDaCarta.values().getAt(simbolosValidos.indexOf(simbolo.toString()))
	}
	
	@Override
	int compareTo(Carta outraCarta) {
		return this.valor <=> outraCarta.valor
	}
	
	@Override
	String toString() {
		return "${this.valor}:${this.naipe}"
	}
}
