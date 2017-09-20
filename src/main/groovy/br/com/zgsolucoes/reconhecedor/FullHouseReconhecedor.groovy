package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria
import br.com.zgsolucoes.reconhecedor.Reconhecedor

class FullHouseReconhecedor extends Reconhecedor {
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return existeGrupos(1, 3, cartas) && existeGrupos(1, 2, cartas) ? Categoria.FULL_HOUSE : null
	}
}
