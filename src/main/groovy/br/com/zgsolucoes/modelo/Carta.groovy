package br.com.zgsolucoes.modelo

class Carta implements Comparable<Carta> {
	
	Naipe naipe
	ValorDaCarta valor
	
	Carta(String carta) throws IllegalArgumentException {
		
		char[] cartaAux = carta.toCharArray()
		String simbolosValidos = "23456789TJQKA"
		String naipeValidos = "HDCS"
		
		if (cartaAux.size() > 2 || !simbolosValidos.contains(cartaAux[0].toString()) || !naipeValidos.contains(cartaAux[1].toString()) ) {
			throw new IllegalArgumentException("Carta inserida invalida")
		}
		
		valor = ValorDaCarta.values().getAt(simbolosValidos.indexOf(cartaAux[0].toString()))
		naipe = Naipe.values().getAt(naipeValidos.indexOf(cartaAux[1].toString()))
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
