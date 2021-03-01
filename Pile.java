
/**
 * Write a description of class Pile here.
 *
 * @author (Diego Rodriguez)
 * @version (11/06/18)
 */
public class Pile
{
    private Card[] pile;
    private int faceUp;
    private int faceDown;
    
    /**
     * No Args Constructor
     * 
     * Sets the fields faceUp and faceDown to 0
     * creates an array of type Card and size 5
     */
   public Pile(){
       pile=new Card[5];
       faceUp=0;
       faceDown=0;
    }
   
    
    /**
     * @param expects a reference to a Card object card
     * 
     * this method assigns a Card object reference to a position within
     * the array of Cards
     */
   public void addCardFaceDown(Card card){
      Card[] newPile = pile;
      pile= new Card[5];
      pile[0]=card;
      for(int x=1;x<pile.length;x++){
                
              pile[x]=newPile[x-1];
            }
        
        faceDown++;
    }
   
    
    /**
     * @return returns the address of the card object within the array
     * of cards at the position 0 while also removing that card reference from
     * the array
     */
   public Card removeCard(){
       Card[] newPile = pile;
       if(faceDown==0){
           return null;
        }
       pile = new Card[5];
           for(int x=0;x<pile.length-1;x++){
               pile[x]=newPile[x+1];
            
        }
        faceDown--;
        return newPile[0];
    }
    
    /**
     * @return returns the field faceDown
     */
    public int getFaceDown(){
        return faceDown;
    }
    
    
    /**
     * @ param expects a reference to a Card object card
     * 
     * this method adds a face up card to the array of card objects to the
     * bottom of the pile
     */
    public void addCardFaceUp(Card card){
        card.setFaceUp(true);
        Card [] newPile = pile;
        pile = new Card[5];
        for(int x = 0 ; x<pile.length ; x++){
            if(x==pile.length-1){
                pile[x]=card;
                break;
            }
            pile[x]=newPile[x];
            faceUp++;
        }
        
    }
    
    
    /**
     * @return returns the faceUp field
     */
    public int getFaceUp(){
     return faceUp;   
    }
    
    
    /**
     * @return returns the string containing all the faceUp(true) 
     * and the string containing all the faceUp(false) 
     */
    public String toString(){
        StringBuilder areFaceUp = new StringBuilder();
        StringBuilder areFaceDown= new StringBuilder();
        areFaceUp.append("Face Up :");
        areFaceDown.append("Face Down :");
        for(int x = 0; x<pile.length;x++){
            if(pile[x]==null&&x!=pile.length-1)
           {
               x++;
            }
            if(pile[x]==null&&x==pile.length-1){
              break;
           }
           
            if(pile[x].getFaceUp()){
                areFaceUp.append(pile[x]+" ");
            }
            
                if(!pile[x].getFaceUp()){
                areFaceDown.append(pile[x]+" ");
            }

        
        }
        return areFaceUp.toString()+" "+areFaceDown.toString();
    }
}
