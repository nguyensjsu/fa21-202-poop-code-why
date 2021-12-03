import greenfoot.*;  

/**
 * Write a description of class WhiteCheckmateState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteCheckmateState implements IBoardState
{
    MyWorld_2 myWorld;
    
    /**
    * Constructor for objects of class WhiteCheckmateState
    */
    public WhiteCheckmateState(MyWorld_2 mw)
    {
        this.myWorld = mw;
    }

    
    public void move()
    {
        
    }
    
    /**
     * Ends the game at checkmate
     */
    public void endGame()
    {
        //myWorld.end();
        Greenfoot.setWorld(new WhiteWonWorld());
    }
}
