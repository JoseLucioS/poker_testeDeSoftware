package poker;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaoTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Carta carta = new Carta(4, Naipe.ESPADAS);
		Assertions.assertEquals(4, carta.getValor());
		Assertions.assertEquals(Naipe.ESPADAS, carta.getNaipe());
	}

	@Test
    public void testRoyalStraightFlush() {

        List<Carta> cartasRoyalFlush = Arrays.asList(
                new Carta(10, Naipe.PAUS),
                new Carta(11, Naipe.PAUS),
                new Carta(12, Naipe.PAUS),
                new Carta(13, Naipe.PAUS),
                new Carta(1, Naipe.PAUS)
        );

        Mao maoRoyalFlush = new Mao(cartasRoyalFlush);
        
        Assertions.assertEquals(RankingMao.ROYAL_STRAIGHT_FLUSH, maoRoyalFlush.ranking());
    }
	
	@Test
    public void testStraightFlush() {

        List<Carta> cartasStraightFlush = Arrays.asList(
                new Carta(5, Naipe.COPAS),
                new Carta(1, Naipe.COPAS),
                new Carta(4, Naipe.COPAS),
                new Carta(2, Naipe.COPAS),
                new Carta(3, Naipe.COPAS)
        );

        Mao maoStraightFlush = new Mao(cartasStraightFlush);
        
        Assertions.assertEquals(RankingMao.STRAIGHT_FLUSH, maoStraightFlush.ranking());
    }
	
	@Test
    public void testIsFourOfAKind() {

        List<Carta> cartasIsFourOfAKind = Arrays.asList(
                new Carta(4, Naipe.ESPADAS),
                new Carta(4, Naipe.OUROS),
                new Carta(4, Naipe.PAUS),
                new Carta(4, Naipe.COPAS),
                new Carta(3, Naipe.COPAS)
        );

        Mao maoIsFourOfAKind = new Mao(cartasIsFourOfAKind);
        
        Assertions.assertEquals(RankingMao.QUADRA, maoIsFourOfAKind.ranking());
    }
	
	@Test
    public void testIsFullHouse() {

        List<Carta> cartasIsFullHouse = Arrays.asList(
                new Carta(4, Naipe.ESPADAS),
                new Carta(4, Naipe.OUROS),
                new Carta(3, Naipe.PAUS),
                new Carta(4, Naipe.PAUS),
                new Carta(3, Naipe.COPAS)
        );

        Mao maoIsFullHouse = new Mao(cartasIsFullHouse);
        
        Assertions.assertEquals(RankingMao.FULL_HOUSE, maoIsFullHouse.ranking());
    }
	
	@Test
    public void testIsFlush() {

        List<Carta> cartasIsFlush = Arrays.asList(
                new Carta(1, Naipe.OUROS),
                new Carta(9, Naipe.OUROS),
                new Carta(7, Naipe.OUROS),
                new Carta(4, Naipe.OUROS),
                new Carta(3, Naipe.OUROS)
        );

        Mao maoIsFlush = new Mao(cartasIsFlush);
        
        Assertions.assertEquals(RankingMao.FLUSH, maoIsFlush.ranking());
    }
	
	@Test
    public void testIsStraight() {

        List<Carta> cartasIsStraight = Arrays.asList(
                new Carta(1, Naipe.PAUS),
                new Carta(2, Naipe.ESPADAS),
                new Carta(5, Naipe.OUROS),
                new Carta(4, Naipe.COPAS),
                new Carta(3, Naipe.OUROS)
        );

        Mao maoIsStraight = new Mao(cartasIsStraight);
        
        Assertions.assertEquals(RankingMao.SEQUENCIA, maoIsStraight.ranking());
    }
	
	@Test
    public void testIsThreeOfAKind() {

        List<Carta> cartasIsThreeOfAKind = Arrays.asList(
                new Carta(6, Naipe.PAUS),
                new Carta(6, Naipe.ESPADAS),
                new Carta(6, Naipe.OUROS),
                new Carta(4, Naipe.COPAS),
                new Carta(3, Naipe.OUROS)
        );

        Mao maoIsThreeOfAKind = new Mao(cartasIsThreeOfAKind);
        
        Assertions.assertEquals(RankingMao.TRINCA, maoIsThreeOfAKind.ranking());
    }
	
	@Test
    public void testIsTwoPairs() {
        
        List<Carta> cartasIsTwoPairs = Arrays.asList(
                new Carta(6, Naipe.PAUS),
                new Carta(6, Naipe.ESPADAS),
                new Carta(8, Naipe.OUROS),
                new Carta(8, Naipe.COPAS),
                new Carta(3, Naipe.OUROS)
        );

        Mao maoIsTwoPairs = new Mao(cartasIsTwoPairs);
        
        Assertions.assertEquals(RankingMao.DOIS_PARES, maoIsTwoPairs.ranking());
    }
	
	@Test
    public void testIsOnePair() {
        
        List<Carta> cartasIsOnePair = Arrays.asList(
                new Carta(6, Naipe.PAUS),
                new Carta(7, Naipe.ESPADAS),
                new Carta(8, Naipe.OUROS),
                new Carta(8, Naipe.COPAS),
                new Carta(3, Naipe.OUROS)
        );

        Mao maoIsOnePair = new Mao(cartasIsOnePair);
        
        Assertions.assertEquals(RankingMao.UM_PAR, maoIsOnePair.ranking());
    }
}
