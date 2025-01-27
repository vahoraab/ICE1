package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier ["Abdulrehman"], [991778205]
 * @date [26 january,2025]
 */
public class CardTrick {

    public static void main(String[] args) {
        
        Card[] magicHand = new Card[7];

        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); 
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); 
            magicHand[i] = c;
        }

        
        System.out.println("The magic hand contains:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPick a cards value (1 to 13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Pick a card  (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() &&
                card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        
        if (found) {
            System.out.println("Your card is in the magic hand! You win!");
        } else {
            System.out.println("Your card is not in the magic hand. Better luck next time!");
        }

        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("\nLucky card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());

        
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() &&
                card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        
        if (luckyFound) {
            System.out.println("The lucky card is in the magic hand! You win!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
}
