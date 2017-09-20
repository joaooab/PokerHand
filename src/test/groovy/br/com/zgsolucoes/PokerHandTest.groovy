package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Categoria
import br.com.zgsolucoes.modelo.PokerHand
import br.com.zgsolucoes.modelo.Resultado
import spock.lang.Specification
import spock.lang.Unroll

class PokerHandTest extends Specification {
	
	@Unroll
	def "obtemTipoCategoria()"() {
		given: " recebe a cartas de poker "
			PokerHand mao1
		when: " verifica sua categoria "
			mao1 = new PokerHand(pMao1)
		then: " confere resultado "
			mao1.categoria == resultadoEsperado
		where:
			pMao1            || resultadoEsperado
			"TC JC QC KC AC" || Categoria.ROYAL_FLUSH
			"6C 7C 8C 9C TC" || Categoria.STRAIGHT_FLUSH
			"AC AH AD AS TC" || Categoria.QUADRA
			"AC AH AD TS TC" || Categoria.FULL_HOUSE
			"2C 3C 6C 7C TC" || Categoria.FLUSH
			"2S 3H 4D 5C 6S" || Categoria.SEQUENCIA
			"AC AH AD 9S TC" || Categoria.TRINCA
			"AC AH 9D TS TC" || Categoria.DOIS_PARES
			"AC 7H 9D TS TC" || Categoria.UM_PAR
			"AC 5H 2D 6S 8C" || Categoria.CARTA_ALTA
	}
	
	@Unroll
	def "compareWith() "(){
		given: " as duas maos de poker "
			PokerHand mao1
			PokerHand mao2
		when: " instanciado as maos de poker "
			mao1 = new PokerHand(pMao1)
			mao2 = new PokerHand(pMao2)
		then: " confere resultado "
			mao1.compareWith(mao2) == resultadoEsperado
		where:
			pMao1            | pMao2            || resultadoEsperado
			"9C TC JC QC KC" | "9C 9H 5C 5H AC" || Resultado.WIN
			"TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || Resultado.WIN
			"TS TD KC JC 7C" | "JS JC AS KC TD" || Resultado.LOSS
			"7H 7C QC JS TS" | "7D 7C JS TS 6D" || Resultado.WIN
			"5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || Resultado.LOSS
			"AS AD KD 7C 3D" | "AD AH KD 7C 4S" || Resultado.LOSS
			"TS JS QS KS AS" | "AC AH AS AS KS" || Resultado.WIN
			"TS JS QS KS AS" | "TC JS QC KS AC" || Resultado.WIN
			"TS JS QS KS AS" | "QH QS QC AS 8H" || Resultado.WIN
			"AC AH AS AS KS" | "TC JS QC KS AC" || Resultado.WIN
			"AC AH AS AS KS" | "QH QS QC AS 8H" || Resultado.WIN
			"TC JS QC KS AC" | "QH QS QC AS 8H" || Resultado.WIN
			"7H 8H 9H TH JH" | "JH JC JS JD TH" || Resultado.WIN
			"7H 8H 9H TH JH" | "4H 5H 9H TH JH" || Resultado.WIN
			"7H 8H 9H TH JH" | "7C 8S 9H TH JH" || Resultado.WIN
			"7H 8H 9H TH JH" | "TS TH TD JH JD" || Resultado.WIN
			"7H 8H 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
			"JH JC JS JD TH" | "4H 5H 9H TH JH" || Resultado.WIN
			"JH JC JS JD TH" | "7C 8S 9H TH JH" || Resultado.WIN
			"JH JC JS JD TH" | "TS TH TD JH JD" || Resultado.WIN
			"JH JC JS JD TH" | "JH JD TH TC 4C" || Resultado.WIN
			"4H 5H 9H TH JH" | "7C 8S 9H TH JH" || Resultado.WIN
			"4H 5H 9H TH JH" | "TS TH TD JH JD" || Resultado.LOSS
			"4H 5H 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
			"7C 8S 9H TH JH" | "TS TH TD JH JD" || Resultado.LOSS
			"7C 8S 9H TH JH" | "JH JD TH TC 4C" || Resultado.WIN
			"TS TH TD JH JD" | "JH JD TH TC 4C" || Resultado.WIN
			"2S 3H 4D 5H 6D" | "5H 6D 7H 8C 9C" || Resultado.LOSS
			"2S 3H 4H 5H 6D" | "2S 3H 4D 5H 6C" || Resultado.DRAW
			"2H 3H 4H 5H 7H" | "2D 3D 4D 5D 8D" || Resultado.LOSS
			"2S 2H 2D 5H 6D" | "5H 5D 5H 8C 9C" || Resultado.LOSS
			"2H 3H 4H 5H 6H" | "5H 6H 7H 8H 9H" || Resultado.LOSS
			"TH JH QH KH AH" | "TC JC QC KC AC" || Resultado.DRAW
			"TH TH TH TH AS" | "9C 9C 9C 9C 2S" || Resultado.WIN
			"TH TH TH AH AS" | "9C 9C 9C 2C 2S" || Resultado.WIN
			"2H 4H 6H 8H AS" | "3C 5C 6C 8C JS" || Resultado.WIN
			"2H 2H 2H AH AS" | "2C 2C 2C JC JS" || Resultado.WIN
			"2H 2H 5H AH AS" | "2C 2C 6C AC AS" || Resultado.LOSS
			"2H 3C 3D 3S 6H" | "2C 3D 4D 5C 6C" || Resultado.LOSS
	}
}
