import java.util.*;
import java.io.*;
/**
 * This is the game ClockSolitaire, it will run a game of solitaire and display
 * the results of the game as well as how the game progressed
 *
 * @author (Diego Rodriguez)
 * @version (a version number or a date)
 */
public class ClockSolitaire
{
    
    /**
     * 
     */
    public static void main(String[]args)throws IOException{
                String printLevel;
                int numGames;
                //the following conditinal statements determine the printLevel
                //and the number of times the game should be played
                if(args.length==2){
                    printLevel=args[0];
                    numGames=Integer.parseInt(args[1]);
                }
                else{
                if(args.length==1){
                    printLevel=args[0];
                    numGames=1;
                }
                else{
                    printLevel="normal";
                    numGames=1;
                }
            }
       
              
            int [] scores = new int[numGames];
                //This is the loop that contains the whole game and runs a
                //certain amount of times depending on the variable numGames
               for(int g =0;g<numGames;g++){
                Deck deck = new Deck();
                Pile[] piles = new Pile[13];
                int score=0;
                int numKings=0;
                int steps=0;
                int removeCardPos=12;
                int addFaceUpPos;
                for(int x =0; x<piles.length;x++){
                    piles[x]= new Pile();
                }
                for(int k = 0; k<4;k++){
                    for(int x =0;x<piles.length;x++){
                       piles[x].addCardFaceDown(deck.dealCard());
                    }
                }
                System.out.println();
                score=0;
                //this is the first official turn of the game
                //It lets the user see what they began with clearest before
                //doing a shorter version for the rest of the game
                    for(int x =0;x<piles.length;x++){
                    if(!printLevel.equalsIgnoreCase("silent")){
                        System.out.println("Pile: "+(x+1));
                        System.out.println(piles[x]);
                     }
                    if(piles[x].getFaceDown()!=0){
                        score++;
                    }
                }
                if(!printLevel.equalsIgnoreCase("silent")){
                    System.out.println("Score: "+score);
                  }
            //the game willplay so long as the score isn't 0 (you win)
            //or 4 kings haven't been flipped(you lose)
                while(numKings!=4&&score!=0){
                    
                    Card removedCard =piles[removeCardPos].removeCard();
                    if(!printLevel.equalsIgnoreCase("silent")){
                    System.out.println("DRAWN CARD IS: "+removedCard);
                      }
                    addFaceUpPos=removedCard.getValue();
                    if(removedCard.getFace().equals("K")){
                        numKings++;
                    }
                    
                    piles[addFaceUpPos].addCardFaceUp(removedCard);
                    if(piles[addFaceUpPos].getFaceDown()==0){
                        if(addFaceUpPos==12){
                            addFaceUpPos=0;
                        }
                        else{
                        addFaceUpPos+=1;
                    }
                    }
                    removeCardPos=addFaceUpPos;
                    score=0;
                    //This loop prints out the game board
                    for(int x =0;x<piles.length;x++){
                    if(!printLevel.equalsIgnoreCase("silent")){
                        System.out.print("Pile: "+(x+1)+" ");
                        System.out.println(piles[x]);
                    }
                        if(piles[x].getFaceDown()!=0){
                            score++;
                        }
                        
                    
                   }
                   
                   //This if prints the score after every draw if the printLevel isn't silent
                   if(!printLevel.equalsIgnoreCase("silent")){
                    System.out.println("Score: "+score);
                    }
                    steps++;
                    //The steps will be counted regardless of printLevel but will only print
                    //if printLevel is 'verbose'
                    if(printLevel.equalsIgnoreCase("verbose")){
                    if(score==0||numKings==4){
                        System.out.println("Steps: "+steps);
                    }
                   }
   
                    if(score==0){
                        System.out.println("\nCongrats you win!!!");
                        scores[g]=score;
                    }
                    if(numKings==4){
                        System.out.println("\nYou lose!!!");
                        scores[g]=score;
                    }
                    
                }
                
                
            }
                           double gamePercent[]=new double [13];
            
                          //this loop adds one to a certain spot within the 
                          //array of doubles gamePercent based on the score at the
                          //end of the game
                        for(int x =0;x<scores.length;x++){
                           gamePercent[scores[x]]++;
                        }
                        //this loop prints out the percent of games with a certain score
                        //by diving the amount of games with a certain score by the total number of games
                        
                        for(int x =0;x<gamePercent.length;x++){
                           System.out.println("Percentage of games with the score as " +x+" was: "+(gamePercent[x]/numGames)*100+"%");
                        }
}

}
