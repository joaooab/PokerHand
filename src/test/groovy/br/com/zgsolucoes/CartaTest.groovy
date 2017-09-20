package br.com.zgsolucoes

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Naipe
import br.com.zgsolucoes.modelo.ValorDaCarta
import spock.lang.Specification
import spock.lang.Unroll

class CartaTest extends Specification {
	
	
	def "Constructor "() {
		given: " cria carta "
		Carta carta
		when: " inicializa "
		carta = new Carta(pCarta)
		then: " confere o resultado "
		carta.valor == valorEsperado
		carta.naipe == naipeEsperado
		where:
		pCarta | valorEsperado     |   naipeEsperado
		"2C"   | ValorDaCarta.DOIS |   Naipe.CLUB
		"8S"   | ValorDaCarta.OITO |   Naipe.SPADE
		"TH"   | ValorDaCarta.T    |   Naipe.HEART
		"AD"   | ValorDaCarta.A    |   Naipe.DIAMOND
	}
	
	@Unroll
	def "Contructor with Throw"() {
		given: " cria carta"
			Carta carta
		when: " inicializa "
			carta = new Carta(pCarta)
		then: " confere o resultado "
			IllegalArgumentException e = thrown()
		where:
			pCarta << ["10C", "9Z", "10Z"]
	}
	
	@Unroll
	//testa todas as linhas do where separadamente
	def "compareTo() "() {
		given: " recebe duas cartas "
		Carta carta1 = new Carta(pCarta1)
		Carta carta2 = new Carta(pCarta2)
		when: " faz a comparacao "
		int comparacao = carta1.compareTo(carta2)
		then: " confere o resultado "
		comparacao == resultadoEsperado
		where:
		pCarta1 | pCarta2 | resultadoEsperado
		"TC"    | "5C"    | 1
		"5C"    | "TC"    | -1
		"5C"    | "5C"    | 0
	}
}
