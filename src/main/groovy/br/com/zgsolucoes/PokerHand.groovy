package br.com.zgsolucoes

class PokerHand {
	
	List<Carta> mao = new ArrayList<>()
	Categoria tipoCategoria
	
	PokerHand(String sequenciaDeCartas) {
		String[] carta = sequenciaDeCartas.split(" ")
		
		carta.each {
			this.mao.add(new Carta(it))
		}
		mao.sort()
		obtemTipoCategoria()
	}
	
	private String getMaoComoString() {
		String saida = ""
		mao.each {
			saida += "${it.simbolo}${it.naipe} "
		}
		return saida.trim()
	}
	
	Resultado compareWith(PokerHand anotherPokerHand) {
		
		if (this.tipoCategoria.ordinal() > anotherPokerHand.tipoCategoria.ordinal()) {
			return Resultado.WIN
		}
		else if (tipoCategoria.ordinal() < anotherPokerHand.tipoCategoria.ordinal()) {
			return Resultado.LOSS
		}
		else {
			Desempate desempate = new Desempate(this, anotherPokerHand)
			return desempate.resultado
		}
	}
	
	private void obtemTipoCategoria() {
		
		if (isRoyalFlush()) {
			this.tipoCategoria = Categoria.ROYAL_FLUSH
		}
		else if (isStraightFlush()) {
			this.tipoCategoria = Categoria.STRAIGHT_FLUSH
		}
		else if (isQuadra()) {
			this.tipoCategoria = Categoria.QUADRA
		}
		else if (isFullHouse()) {
			this.tipoCategoria = Categoria.FULL_HOUSE
		}
		else if (isFlush()) {
			this.tipoCategoria = Categoria.FLUSH
		}
		else if (isSequencia()) {
			this.tipoCategoria = Categoria.SEQUENCIA
		}
		else if (isTrinca()) {
			this.tipoCategoria = Categoria.TRINCA
		}
		else if (isDoisPares()) {
			this.tipoCategoria = Categoria.DOIS_PARES
		}
		else if (isUmPar()) {
			this.tipoCategoria = Categoria.UM_PAR
		}
		else {
			this.tipoCategoria = Categoria.CARTA_ALTA
		}
	}
	
	private boolean isRoyalFlush() {
		if (isStraightFlush()) {
			return getMaoComoString().matches("T\\w J\\w Q\\w K\\w A\\w")
		}
		return false
	}
	
	private boolean isStraightFlush() {
		return isSequencia() && isFlush()
	}
	
	private boolean isQuadra() {
		return existeGrupos(1, 4)
	}
	
	private boolean isFullHouse() {
		return isTrinca() && isUmPar()
	}
	
	private boolean isFlush() {
		return this.mao.groupBy { Carta carta -> carta.naipe }.size() == 1
	}
	
	private boolean isSequencia() {
		return (this.mao.valor.max().ordinal() - this.mao.valor.min().ordinal() == 4) &&
				existeGrupos(5, 1)
	}
	
	private boolean isTrinca() {
		return existeGrupos(1, 3)
	}
	
	private boolean isDoisPares() {
		return existeGrupos(2, 2)
	}
	
	private boolean isUmPar() {
		return existeGrupos(1, 2)
	}
	
	private boolean existeGrupos(int quantidadeGrupos, int tamanhoGrupos) {
		return this.mao.groupBy { Carta carta -> carta.valor }.values()
				.findAll { List<Carta> grupo -> grupo.size() == tamanhoGrupos }
				.size() == quantidadeGrupos
	}
}