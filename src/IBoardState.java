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
