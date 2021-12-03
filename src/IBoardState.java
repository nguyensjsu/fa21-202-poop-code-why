/**
 * Write a description of class IBoardState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IBoardState
{
    
    /**
     * Move the piece
     */
    public void move();

    /**
     * Ends the game at checkmate
     */
    public void endGame();
}
