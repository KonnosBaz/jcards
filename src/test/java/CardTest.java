
import io.lyuda.jcards.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static io.lyuda.jcards.Card.Suit;
import static io.lyuda.jcards.Card.Rank;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for the {@link Card} class.
 *
 * @author lyudaio
 * @since 0.0.1
 */
public class CardTest {

    /**
     * Test method for the constructor of the {@code Card} class.
     * This method tests the scenario when both rank and suit are not null.
     */
    @Test
    public void testCard_validInput() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        assertNotNull(card);
    }

    /**
     * Test method for the constructor of the {@code Card} class.
     * This method tests the scenario when rank is null.
     */
    @Test
    public void testCard_nullRank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Card(null, Card.Suit.CLUBS);
        });
    }


    /**
     * Test method for the constructor of the {@code Card} class.
     * This method tests the scenario when suit is null.
     */
    @Test
    public void testCard_nullSuit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Card.Rank.ACE, null);
        });
    }


    /**
     * Test method for the {@code getRank} method of the {@code Card} class.
     */
    @Test
    public void testGetRank() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        assertEquals(Card.Rank.ACE, card.getRank());
    }

    /**
     * Test method for the {@code getSuit} method of the {@code Card} class.
     */
    @Test
    public void testGetSuit() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        assertEquals(Card.Suit.CLUBS, card.getSuit());
    }

    /**
     * Test method for the {@code toString} method of the {@code Card} class.
     */
    @Test
    public void testToString() {
        Card card = new Card(Card.Rank.ACE, Suit.CLUBS);
        assertEquals("ACE of CLUBS", card.toString());
    }

    /**
     * Test method for the {@code hashCode} method of the {@code Card} class.
     */
    @Test
    public void testHashCode() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        int expectedHashCode = Objects.hash(Card.Rank.ACE, Card.Suit.CLUBS);
        assertEquals(expectedHashCode, card.hashCode());
    }


    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the objects being compared have different rank values.
     */
    @Test
    public void testEquals_differentRankValues() {
        // Given
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.KING, Suit.HEARTS);

        // When
        boolean result = card1.equals(card2);

        // Then
        assertFalse(result);
    }

    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the objects being compared have different suit values.
     */
    @Test
    public void testEquals_differentSuitValues() {
        // Given
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.CLUBS);

        // When
        boolean result = card1.equals(card2);

        // Then
        assertFalse(result);
    }

    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the object being compared is {@code null}.
     */
    @Test
    public void testEquals_nullObject() {
        // Given
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);

        // When
        boolean result = card1.equals(null);

        // Then
        assertFalse(result);
    }

    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the object being compared is of a different type.
     */
    @Test
    public void testEquals_differentObjectType() {
        // Given
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);

        // When
        boolean result = card1.equals("not a card");

        // Then
        assertFalse(result);
    }

    /**
     * Test method for the {@code hashCode} method of the {@code Card} class.
     * This method tests that the hash code generated for two equal objects is the same.
     */
    @Test
    public void testHashCode_equalObjects() {
        // Given
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);

        // When
        int hash1 = card1.hashCode();
        int hash2 = card2.hashCode();

        // Then
        assertEquals(hash1, hash2);
    }

    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the objects being compared are equal.
     */
    @Test
    public void testEquals_equalObjects() {
        Card card1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        assertTrue(card1.equals(card2));
    }

    /**
     * Test method for the {@code equals} method of the {@code Card} class.
     * This method tests the scenario when the objects being compared are not equal.
     */
    @Test
    public void testEquals_notEqualObjects() {
        Card card1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        assertFalse(card1.equals(card2));
    }

}




