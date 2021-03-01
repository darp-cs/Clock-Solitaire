/**
 * Card object class, represents a Card
 * @author (Diego Rodriguez)
 * @version (11/06/18)
 */
public class Card
{
   private String suit;//Holds the suit of the card object
   private String face;//Holds the face of the card object
   private int value;//Holds the numerical value of the 
   private boolean faceUp;
   private boolean dealt;
   /**
    * No args constructor
    * 
    * sets all fields to default value
    */
   public Card(){
   
       suit=null;
       face=null;
       value=0;
       faceUp=false;
       dealt=false;
    }

    /**
     * @param expects a String s
     * String f, int v, boolean Fu, boolean d
     * 
     * sets all the fields to the respective parameter value
     */
   public Card(String s, String f, int v, boolean fU,boolean d){
   
       suit=s;
       face=f;
       value=v;
       faceUp=fU;
       dealt=d;
    }
    
    /**
     * @param expects a reference to a card object other
     * 
     * creates a card object based on the parameter
     */
   public Card(Card other){
       this.suit=other.suit;
       this.face=other.suit;
       this.value=other.value;
       this.faceUp=other.faceUp;
       this.dealt=other.dealt;
    }
    
    
    /**
     * @return returns the field suit
     */
   public String getSuit(){
       return suit;
    }
    
    
    /**
     * @return returns the field face
     */
   public String getFace(){
       return face;
    }
    
    
    /**
     * @return returns the field value
     */
   public int getValue(){
       return value;
    }
    
    
    /**
     *return returns the field faceUp
     */
   public boolean getFaceUp(){
       return faceUp; 
    }
    
    
    /**
     * @return returns the field dealt
     */
   public boolean getDealt(){
       return dealt;
    }
    
    /**
     * @param expects a String s
     * 
     * sets suit equal to the parameter s
     */
   public void setSuit(String s){
        suit=s;
    }
    
    
    /**
     * @param expects a String f
     * 
     * sets face equal to the parameter f
     */
   public void setFace(String f){
      face=f;
    }
    
    
    /**
     * @param expects an int v
     * 
     * sets value equal to v
     */
   public void setValue(int v){
       value=v;
    }
    
    
    /**
     * @param expects a boolean fU
     * 
     * sets faceUp equal to fU
     */
   public void setFaceUp(boolean fU){
       faceUp=fU;
    }
    
    
    /**
     * @param expects a boolean sD
     * 
     * sets dealt equals to sD
     */
   public void setDealt(boolean sD){
       dealt=sD;
    }
  
    
    /**
     * @return returns a string concatination of face and suit
     */
   public String toString(){
       return face+suit;
    }
}
