package poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 */
public class Mao {
	private List<Carta> cartas;

	public Mao(List<Carta> cartas) {
		this.setCartas(cartas);
	}

	public RankingMao ranking() {
		Collections.sort(cartas);
		
		RankingMao ranking;
		
		if(isRoyalStraightFlush()) {
			ranking = RankingMao.ROYAL_STRAIGHT_FLUSH;
		} else if(isStraightFlush()) {
			ranking = RankingMao.STRAIGHT_FLUSH;
		} else if(isFourOfAKind()) {
			ranking = RankingMao.QUADRA;
		} else if(isFullHouse()) {
			ranking = RankingMao.FULL_HOUSE;
		} else if(isFlush()) {
			ranking = RankingMao.FLUSH;
		} else if(isStraight()) {
			ranking = RankingMao.SEQUENCIA;
		} else if(isThreeOfAKind()) {
			ranking = RankingMao.TRINCA;
		} else if(isTwoPairs()) {
			ranking = RankingMao.DOIS_PARES;
		} else if(isOnePair()) {
			ranking = RankingMao.UM_PAR;
		} else {
			ranking = RankingMao.NADA;
		}
		
		return ranking;
	}

	private boolean isOnePair() {
		//Contagem de ocorrências de cada valor
	    Map<Integer, Long> contagemValores = cartas.stream()
	            .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

	    //Verifica se há um valor que ocorre duas vezes
	    return contagemValores.containsValue(2L);
	}

	private boolean isTwoPairs() {
		
		//Contagem de ocorrências de cada valor
	    Map<Integer, Long> contagemValores = cartas.stream()
	            .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

	    //Conta o número de pares
	    long numeroDePares = contagemValores.values().stream().filter(count -> count == 2L).count();

	    return numeroDePares == 2;
	}

	private boolean isThreeOfAKind() {

		//Contagem de ocorrências de cada valor
	    Map<Integer, Long> contagemValores = cartas.stream()
	            .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

	    //Verifica se há um valor que ocorre três vezes
	    return contagemValores.containsValue(3L);
	}

	private boolean isStraight() {

	    int tamanhoMao = cartas.size();
	    
	    //verifica se a sequencia é 1, 2, 3, 4, 5, caracterizando um straight
	  	List<Integer> valoresEsperados = Arrays.asList(2, 3, 4, 5, 1);
	  	List<Integer> valoresCartas = cartas.stream().map(Carta::getValor).collect(Collectors.toList());
	  		
	  	if(valoresCartas.equals(valoresEsperados)) {
	  		return true;
	  	}
	    
	    for (int i = 0; i < tamanhoMao - 1; i++) {
	        int valorAtual = cartas.get(i).getValor();
	        int proximoValor = cartas.get(i + 1).getValor();

	        if((proximoValor - valorAtual) != 1) {
	        	return false;
	        }
	        
	    }

	    return true;
	}

	private boolean isFlush() {
		//Verifica se todas as cartas têm o mesmo naipe
	    return cartas.stream().allMatch(carta -> carta.getNaipe().equals(cartas.get(0).getNaipe()));
	}

	private boolean isFullHouse() {
		
		// Contagem de ocorrências de cada valor
	    Map<Integer, Long> contagemValores = cartas.stream()
	            .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

	    // Verifica se há um valor que ocorre 3 vezes e outro que ocorre 2 vezes
	    return contagemValores.containsValue(3L) && contagemValores.containsValue(2L);
	}

	private boolean isFourOfAKind() {
		
		// Conta as ocorrências de cada valor
	    Map<Integer, Long> contagemValores = cartas.stream()
	            .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

	    // Verifica se há um valor que ocorre quatro vezes
	    return contagemValores.containsValue(4L);
	}

	private boolean isStraightFlush() {
		
		boolean naipesIguais = cartas.stream().allMatch(carta -> carta.getNaipe().equals(cartas.get(0).getNaipe()));
		
		if(!naipesIguais) {
			return false;
		}
		
		//verifica se a sequencia é 1, 2, 3, 4, 5 do mesmo naipe, caracterizando um straight flush
		List<Integer> valoresEsperados = Arrays.asList(2, 3, 4, 5, 1);
		List<Integer> valoresCartas = cartas.stream().map(Carta::getValor).collect(Collectors.toList());
		
		if(valoresCartas.equals(valoresEsperados)) {
			return true;
		}
		
		int tamanhoMao = cartas.size();
		
		//verifica se as cartas formam uma sequencia válida
		for(int i = 0; i < tamanhoMao - 1; i++) {
			
			int valorAtual = cartas.get(i).getValor();
			int proximoValor = cartas.get(i + 1).getValor();

			if((proximoValor - valorAtual) != 1) {
				return false;
			}
			
		}
		
		//se chegou até aqui, entao é uma sequencia válida
		return true;
	}

	private boolean isRoyalStraightFlush() {
		//verifica se as cartas possuem o mesmo naipe
		boolean naipesIguais = cartas.stream().allMatch(carta -> carta.getNaipe().equals(cartas.get(0).getNaipe()));
		
		if(!naipesIguais) {
			return false;
		}
		
		List<Integer> valoresEsperados = Arrays.asList(10, 11, 12, 13, 1);
		List<Integer> valoresCartas = cartas.stream().map(Carta::getValor).collect(Collectors.toList());
		
		return valoresCartas.equals(valoresEsperados);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
}
