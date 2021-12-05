/**
 * Write a description of class BlackCheckmateState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalState implements IBoardState
{
    MyWorld_2 myWorld;
    
    /**
    * Constructor for objects of class NormalState
    */
    public NormalState(MyWorld_2 mw)
    {
        this.myWorld = mw;
    }

    /**
     * Move the piece
     * Calls the move function of the world
     */
    public void move()
    {
        myWorld.movePiece();
    }
    
    /**
     * Ends the game at checkmate
     */
    public void endGame()
    {   
        //Still in normal state, cant end game
    }
}
