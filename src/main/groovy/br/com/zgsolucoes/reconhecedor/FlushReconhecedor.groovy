package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria

class FlushReconhecedor extends Reconhecedor{
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return isFlush(cartas) ? Categoria.FLUSH : null
	}
}
