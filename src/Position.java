/**
 * The class Position is used to be able to build a Position from a pair of
 * coordinates or from a given Piece and to compare a Position with a pair
 * of coordinates or with the one of a given Piece.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class Position {
   
    int x;
    int y;
    
    /**
     * Constructor for Position
     * 
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructor for Position
     * 
     * @param p
     */
    public Position(greenfoot.Actor p) {
        this.x = p.getX();
        this.y = p.getY();
    }   
    
    public boolean correspondsTo(int x, int y) {
        return this.x == x && this.y == y;
    }
    
    public boolean correspondsTo(Position p) {
        return this.x == p.getX() && this.y == p.getY();
    }
    
    /**
     * Gets the x position
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y position
     * 
     * @return y
     */
    public int getY() {
        return y;
    }
}
