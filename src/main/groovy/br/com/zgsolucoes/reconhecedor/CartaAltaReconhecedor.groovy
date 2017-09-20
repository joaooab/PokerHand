package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria

class CartaAltaReconhecedor extends Reconhecedor{
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return Categoria.CARTA_ALTA
	}
}
