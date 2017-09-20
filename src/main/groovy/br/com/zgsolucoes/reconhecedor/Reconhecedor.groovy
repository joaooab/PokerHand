
package br.com.zgsolucoes.reconhecedor

import br.com.zgsolucoes.modelo.*

abstract class Reconhecedor {
	
	protected boolean isFlush(List<Carta> cartas) {
		boolean saida
		saida = cartas.groupBy { Carta carta -> carta.naipe }.size() == 1
		return saida
	}
	
	protected boolean isSequencia(List<Carta> cartas) {
		boolean saida
		saida = (cartas.valor.max().ordinal() - cartas.valor.min().ordinal() == 4) && existeGrupos(5, 1, cartas)
		return saida
	}
	
	protected boolean existeGrupos(int quantidadeGrupos, int tamanhoGrupos, List<Carta> cartas) {
		return cartas.groupBy { Carta carta -> carta.valor }.values()
				.findAll { List<Carta> grupo -> grupo.size() == tamanhoGrupos }
				.size() == quantidadeGrupos
	}
	
	abstract Categoria obtemCategoria(List<Carta> cartas)
	
}
