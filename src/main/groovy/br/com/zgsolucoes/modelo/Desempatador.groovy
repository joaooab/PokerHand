package br.com.zgsolucoes.modelo

class Desempatador {
	
	static Resultado getResultadoDesempate(PokerHand pokerHand, PokerHand anotherPokerHand) {
		List<ValorDaCarta> listaDeGupos1 = getGruposPorCategoria(pokerHand)
		List<ValorDaCarta> listaDeGupos2 = getGruposPorCategoria(anotherPokerHand)
		
		for (int i = 0; i < listaDeGupos1.size(); i++) {
			if (listaDeGupos1[i].ordinal() > listaDeGupos2[i].ordinal()) {
				return Resultado.WIN
			}
			else if (listaDeGupos1[i].ordinal() < listaDeGupos2[i].ordinal()) {
				return Resultado.LOSS
			}
		}
		return Resultado.DRAW
	}
	
	static private List<ValorDaCarta> getGruposPorCategoria(PokerHand pokerHand) {
		List<ValorDaCarta> listaDeGruposPorCategoria = pokerHand.cartas.groupBy { Carta carta ->
			carta.valor
		}.values().sort {
			it.size()
		}.reverse().collect {
			return it.first().valor
		}
		return listaDeGruposPorCategoria
	}
}
