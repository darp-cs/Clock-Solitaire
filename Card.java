
/**
 * @author (Diego Rodriguez)
 * @version (11-06-18)
 */
public class Card
{
   private String face;
   private String suit;
   private int value;
   public Card()
   {
       face="";
       suit="";
       value=0;
    }
   public Card(String f, String s, int v)
   {
       face=f;
       suit=s;
       value=v;
    }
   public Card(Card other)
    {
        this.face=other.face;
        this.suit=other.suit;
        this.value=other.value;
    }
   public void setValue(int x)
   {
       value=x;
    }
   public String getFace()
   {
       return face;
    }
   public String getSuit()
    {
       return suit; 
    }
   public int getValue()
   {
      return value; 
    }
   public int compareTo(Card other)
   {
       return this.value-other.value;  
    }
   public boolean equals(Card other)
   {
       if(this.face.equals(other.face)&&this.suit.equals(other.suit))
       {
           return true;
        }
       return false;
    }
   public String toString()
    {
        return "Face: "+face
        +"\nSuit: "+suit
        +"\nValue: "+value;
        
    }
    

}
