package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria

class QuadraReconhecedor extends Reconhecedor {

	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return existeGrupos(1, 4, cartas) ? Categoria.QUADRA : null
	}
}
