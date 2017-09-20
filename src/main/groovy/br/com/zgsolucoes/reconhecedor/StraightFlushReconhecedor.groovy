package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria

class StraightFlushReconhecedor extends Reconhecedor {
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return isFlush(cartas) && isSequencia(cartas) ? Categoria.STRAIGHT_FLUSH: null
	}
}
