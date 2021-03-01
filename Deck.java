/**
 * Deck object class made up of 52 cardobjects each
 * @author (Diego Rodriguez)
 * @version (11/06/18)
 */
import java.util.*;
public class Deck
{
    private Card[] deck;
    private int cardsLeft;
    private Random rand = new Random();
    private final String[] SUITS ={"H","D","C","S"};
    private final String[] FACES={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final int[] VALUES={1,2,3,4,5,6,7,8,9,10,11,12,0};
    
    /**
     * No Args Constructor
     * creates a Deck object containing an array of 52 card objects
     * each given their fields through 3 different arrays
     * SUITS, FACES, and VALUES and then finally shuffles the deck using
     * the shuffle method
     */
    public Deck(){
        deck=new Card[52];
        cardsLeft=deck.length;
        int countingCard=0;
        for(int suitPos=0;suitPos<SUITS.length;suitPos++){
            for(int facePos=0;facePos<FACES.length;facePos++){
                deck[countingCard]=new Card(SUITS[suitPos],FACES[facePos],VALUES[facePos],false,false);
                countingCard++;
            }
        }
        shuffle();
    }
    
    /**
     * creates a temporary card object that will hold the reference of a card object
     * it then trades that card out at random for another and the temp is moved
     * to the spot of the replacement card
     */
    public void shuffle(){
        
        Card tempCard = new Card();
        for(int x=0;x<52;x++){
            tempCard=deck[x];
            int random = rand.nextInt(52);
            deck[x]=deck[random];
            deck[random]=tempCard;
        }
        
    }
    /**
     * @return returns the field cardsLeft
     */
    public int cardsLeft(){
        return cardsLeft;
    }
    
    
    /**
     * return returns the adress of a card object
     */
    public Card dealCard(){
        int unDealt =-1;
        for(int x=0;x<deck.length;x++){
            if(deck[x].getDealt()==false){
                deck[x].setDealt(true);
                cardsLeft--;
                unDealt=x;
                break;
            }
        }
        return deck[unDealt];
    }
    
    /**
     * returns a String concatination of the toString of unDealt cards and the toString of Dealt cards
     * 
     * Goes through the deck and if deck[x].getDealt = falseit adds that card object
     * to the unDealt StringBuilder otherwise if it is true
     * it will add that card to the alreadyDealt StringBuilder
     */
    public String toString(){
        StringBuilder unDealt = new StringBuilder();
        StringBuilder alreadyDealt = new StringBuilder();
        for(int x=0;x<deck.length;x++){
            if(deck[x].getDealt()==false){
                unDealt.append(deck[x].toString());
            }
        }
        for(int x=0;x<deck.length;x++){
           if(deck[x].getDealt()==true){
                alreadyDealt.append(deck[x].toString());
            } 
        }
        
        return "Cards that have not been dealt: "+unDealt.toString()+"\nCards that have already been dealt: "+alreadyDealt.toString();
    }
    
   
}
