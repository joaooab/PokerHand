package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.*

class RoyalFlushReconhecedor extends Reconhecedor {
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return isFlush(cartas) && isSequencia(cartas) && cartas.first().valor == ValorDaCarta.T ? Categoria.ROYAL_FLUSH : null
	}
}
