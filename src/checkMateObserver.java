import greenfoot.*;  
/**
 * Write a description of class checkMateObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class checkMateObserver  implements IStateObserver
{
    // instance variables - replace the example below with your own
    
      //states
    private NormalState normalState;
    private WhiteCheckmateState whiteCMState;
    private BlackCheckmateState blackCMState;
    MyWorld_2 myWorld ;
    /**
     * Constructor for objects of class checkMateObserver
     */
    public checkMateObserver(MyWorld_2 mw)
    {
        this.myWorld = mw;
        blackCMState = new BlackCheckmateState(this.myWorld);
        whiteCMState = new WhiteCheckmateState(this.myWorld);
    }
    
    public void checkmateEvent(){
                            
                        // If white captures the king
                        // then white wins the game
                        if(this.myWorld.turn == -1)
                            this.myWorld.changeState(whiteCMState);
                        // If black captures the king
                        // then black wins the game
                        else if(this.myWorld.turn == 1)
                            // State changes to black checkmate state, where endgame method is called
                            this.myWorld.changeState(blackCMState);
                    
    };

    
   
}
