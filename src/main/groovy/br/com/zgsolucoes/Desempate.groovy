package br.com.zgsolucoes

class Desempate {
	
	Resultado resultado = Resultado.DRAW
	
	Desempate(PokerHand pokerHand, PokerHand anotherPokerHand) {
		List<ValorDaCarta> listaDeGupos1 = getGruposPorCategoria(pokerHand)
		List<ValorDaCarta> listaDeGupos2 = getGruposPorCategoria(anotherPokerHand)
		
		if (!listaDeGupos1.isEmpty()) {
			compareGrupos(listaDeGupos1, listaDeGupos2)
		}
	}
	
	static private List<ValorDaCarta> getGruposPorCategoria(PokerHand pokerHand) {
		List<ValorDaCarta> listaDeGruposPorCategoria = new ArrayList<>()
		
		pokerHand.mao.groupBy { Carta carta -> carta.valor }.values().sort {
			it.size()
		}.reverse().each {
			listaDeGruposPorCategoria.add(it.first().valor)
		}
		
		return listaDeGruposPorCategoria
	}

	
	private void compareGrupos(List<ValorDaCarta> listaDeGupos1, List<ValorDaCarta> listaDeGupos2) {
		for (int i = 0; i < listaDeGupos1.size(); i++) {
			if(listaDeGupos1[i].ordinal() > listaDeGupos2[i].ordinal()){
				resultado = Resultado.WIN
				return
			}
			else if (listaDeGupos1[i].ordinal() < listaDeGupos2[i].ordinal()){
				resultado = Resultado.LOSS
				return
			}
		}
	}
}
