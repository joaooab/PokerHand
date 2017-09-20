package br.com.zgsolucoes.modelo

import br.com.zgsolucoes.reconhecedor.*

class PokerHand {
	
	List<Carta> cartas = new ArrayList<>()
	Categoria categoria
	
	private static final List<Reconhecedor> reconhecedores = Arrays.asList(
			new RoyalFlushReconhecedor(),
			new StraightFlushReconhecedor(),
			new QuadraReconhecedor(),
			new FullHouseReconhecedor(),
			new FlushReconhecedor(),
			new SequenciaReconhecedor(),
			new TrincaReconhecedor(),
			new DoisParesReconhecedor(),
			new UmParReconhecedor()
	)
	
	
	PokerHand(String sequenciaDeCartas) {
		String[] carta = sequenciaDeCartas.split(" ")
		
		carta.collect() {
			this.cartas.add(new Carta(it))
		}
		
		cartas.sort()
		
		for (Reconhecedor reconhecedor : reconhecedores) {
			Categoria categoria = reconhecedor.obtemCategoria(cartas)
			if (categoria != null) {
				this.categoria = categoria
				break
			}
		}
		if (categoria == null) {
			this.categoria = Categoria.CARTA_ALTA
		}
	}
	
	Resultado compareWith(PokerHand anotherPokerHand) {
		
		if (this.categoria.ordinal() > anotherPokerHand.categoria.ordinal()) {
			return Resultado.WIN
		}
		else if (categoria.ordinal() < anotherPokerHand.categoria.ordinal()) {
			return Resultado.LOSS
		}
		else {
			return Desempatador.getResultadoDesempate(this, anotherPokerHand)
		}
	}
}