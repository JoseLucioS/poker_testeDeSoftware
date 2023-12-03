package poker;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaoTest {

	@Test
    public void testRoyalStraightFlush() {

        List<Carta> cartasRoyalStraightFlush = Arrays.asList(
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(11).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(12).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(13).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build()
        );

        Mao maoRoyalStraightFlush = new Mao(cartasRoyalStraightFlush);
        
        Assertions.assertEquals(RankingMao.ROYAL_STRAIGHT_FLUSH, maoRoyalStraightFlush.ranking());
    }
	
	@Test
    public void testNOTRoyalStraightFlush() {

        List<Carta> cartasNOTRoyalStraightFlush = Arrays.asList(
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(11).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(12).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(13).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build()
        );

        Mao maoNOTRoyalStraightFlush = new Mao(cartasNOTRoyalStraightFlush);
        
        Assertions.assertNotEquals(RankingMao.ROYAL_STRAIGHT_FLUSH, maoNOTRoyalStraightFlush.ranking());
    }
	
	@Test
    public void testStraightFlush() {

        List<Carta> cartasStraightFlush = Arrays.asList(
        		new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(2).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.PAUS).build()
        );

        Mao maoStraightFlush = new Mao(cartasStraightFlush);
        
        Assertions.assertEquals(RankingMao.STRAIGHT_FLUSH, maoStraightFlush.ranking());
    }
	
	@Test
    public void testNOTStraightFlush() {

        List<Carta> cartasNOTStraightFlush = Arrays.asList(
        		new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(2).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(6).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.PAUS).build()
        );

        Mao maoNOTStraightFlush = new Mao(cartasNOTStraightFlush);
        
        Assertions.assertNotEquals(RankingMao.STRAIGHT_FLUSH, maoNOTStraightFlush.ranking());
    }
	
	@Test
    public void testIsFourOfAKind() {

        List<Carta> cartasIsFourOfAKind = Arrays.asList(
        		new CartaBuilder().withValor(7).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.PAUS).build()
        );

        Mao maoIsFourOfAKind = new Mao(cartasIsFourOfAKind);
        
        Assertions.assertEquals(RankingMao.QUADRA, maoIsFourOfAKind.ranking());
    }
	
	@Test
    public void testIsNOTFourOfAKind() {

        List<Carta> cartasIsNOTFourOfAKind = Arrays.asList(
        		new CartaBuilder().withValor(7).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.PAUS).build()
        );

        Mao maoIsNOTFourOfAKind = new Mao(cartasIsNOTFourOfAKind);
        
        Assertions.assertNotEquals(RankingMao.QUADRA, maoIsNOTFourOfAKind.ranking());
    }
	
	@Test
    public void testIsFullHouse() {

        List<Carta> cartasIsFullHouse = Arrays.asList(
        		new CartaBuilder().withValor(7).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build()
        );

        Mao maoIsFullHouse = new Mao(cartasIsFullHouse);
        
        Assertions.assertEquals(RankingMao.FULL_HOUSE, maoIsFullHouse.ranking());
    }
	
	@Test
    public void testIsNOTFullHouse() {

        List<Carta> cartasIsNOTFullHouse = Arrays.asList(
        		new CartaBuilder().withValor(7).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build()
        );

        Mao maoIsNOTFullHouse = new Mao(cartasIsNOTFullHouse);
        
        Assertions.assertNotEquals(RankingMao.FULL_HOUSE, maoIsNOTFullHouse.ranking());
    }
	
	@Test
    public void testIsFlush() {

        List<Carta> cartasIsFlush = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(8).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsFlush = new Mao(cartasIsFlush);
        
        Assertions.assertEquals(RankingMao.FLUSH, maoIsFlush.ranking());
    }
	
	@Test
    public void testIsNOTFlush() {

        List<Carta> cartasIsNOTFlush = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(6).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsNOTFlush = new Mao(cartasIsNOTFlush);
        
        Assertions.assertNotEquals(RankingMao.FLUSH, maoIsNOTFlush.ranking());
    }
	
	@Test
    public void testIsStraight() {

        List<Carta> cartasIsStraight = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(6).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsStraight = new Mao(cartasIsStraight);
        
        Assertions.assertEquals(RankingMao.SEQUENCIA, maoIsStraight.ranking());
    }
	
	@Test
    public void testIsNOTStraight() {

        List<Carta> cartasIsNOTStraight = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(4).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(9).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsNOTStraight = new Mao(cartasIsNOTStraight);
        
        Assertions.assertNotEquals(RankingMao.SEQUENCIA, maoIsNOTStraight.ranking());
    }
	
	@Test
    public void testIsThreeOfAKind() {

        List<Carta> cartasIsThreeOfAKind = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(9).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsThreeOfAKind = new Mao(cartasIsThreeOfAKind);
        
        Assertions.assertEquals(RankingMao.TRINCA, maoIsThreeOfAKind.ranking());
    }
	
	@Test
    public void testIsNOTThreeOfAKind() {

        List<Carta> cartasIsNOTThreeOfAKind = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(9).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsNOTThreeOfAKind = new Mao(cartasIsNOTThreeOfAKind);
        
        Assertions.assertNotEquals(RankingMao.TRINCA, maoIsNOTThreeOfAKind.ranking());
    }
	
	@Test
    public void testIsTwoPairs() {
        
        List<Carta> cartasIsTwoPairs = Arrays.asList(
        		new CartaBuilder().withValor(3).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsTwoPairs = new Mao(cartasIsTwoPairs);
        
        Assertions.assertEquals(RankingMao.DOIS_PARES, maoIsTwoPairs.ranking());
    }
	
	@Test
    public void testIsNOTTwoPairs() {
        
        List<Carta> cartasIsNOTTwoPairs = Arrays.asList(
        		new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsNOTTwoPairs = new Mao(cartasIsNOTTwoPairs);
        
        Assertions.assertNotEquals(RankingMao.DOIS_PARES, maoIsNOTTwoPairs.ranking());
    }
	
	@Test
    public void testIsOnePair() {
        
        List<Carta> cartasIsOnePair = Arrays.asList(
        		new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(10).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsOnePair = new Mao(cartasIsOnePair);
        
        Assertions.assertEquals(RankingMao.UM_PAR, maoIsOnePair.ranking());
    }
	
	@Test
    public void testIsNOTOnePair() {
        
        List<Carta> cartasIsNOTOnePair = Arrays.asList(
        		new CartaBuilder().withValor(10).withNaipe(Naipe.OUROS).build(),
                new CartaBuilder().withValor(5).withNaipe(Naipe.ESPADAS).build(),
                new CartaBuilder().withValor(1).withNaipe(Naipe.PAUS).build(),
                new CartaBuilder().withValor(3).withNaipe(Naipe.COPAS).build(),
                new CartaBuilder().withValor(7).withNaipe(Naipe.ESPADAS).build()
        );

        Mao maoIsNOTOnePair = new Mao(cartasIsNOTOnePair);
        
        Assertions.assertNotEquals(RankingMao.UM_PAR, maoIsNOTOnePair.ranking());
    }
}
