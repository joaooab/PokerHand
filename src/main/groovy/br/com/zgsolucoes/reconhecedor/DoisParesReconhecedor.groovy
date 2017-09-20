package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.Carta
import br.com.zgsolucoes.modelo.Categoria
import br.com.zgsolucoes.reconhecedor.Reconhecedor

class DoisParesReconhecedor extends Reconhecedor {
	
	@Override
	Categoria obtemCategoria(List<Carta> cartas) {
		return existeGrupos(2, 2, cartas) ? Categoria.DOIS_PARES : null
	}
}
