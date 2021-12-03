import greenfoot.*;  


/**
 * Write a description of class BlackCheckmateState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackCheckmateState implements IBoardState
{
    MyWorld_2 myWorld ;
    
    /**
    * Constructor for objects of class BlackCheckmateState
    */
    public BlackCheckmateState(MyWorld_2 mw)
    {
        this.myWorld = mw;
    }

    /**
     * Move the piece
     * Not used since game is ended
     */
    public void move()
    {
        
    }
    
    /**
     * Ends the game at checkmate
     */
    public void endGame()
    {
        //myWorld.end();
        Greenfoot.setWorld(new BlackWonWorld());
    }
}
