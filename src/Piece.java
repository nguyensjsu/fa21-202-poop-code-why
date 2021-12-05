import greenfoot.*;
import java.util.List;
/**
 * Abstract Piece class.
 * It keeps track of the color/direction in an attribute cd.
 * The value 1 encodes Black, the value -1 is for White.
 * This is used to select the image for the piece, determine who's turn it is
 * and the playing direction of the Pawn.
 * The "act" method is used to select a piece with the mouse.
 * Each instance of a Piece must implement 
 * the abstract method getLegalPositions(), which returns a list of the legal
 * moves for that piece in the given position.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public abstract class Piece extends Actor {
    int cd;
    boolean isSelected;
    IMoveStrategy currStrategy;
    
    /**
     * constructor for Piece
     */
    Piece() {
        super();
    }

    /**
     * constructor for Piece with CD
     */
    Piece(int cd) {
        super();
        this.cd = cd;
        isSelected = false;
    }

    public void setCurrStrategy(IMoveStrategy strat) {
        currStrategy = strat;
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            select();
        }
    }  

    /**
     * Select a Piece
     */
    public void select() {
        if (((MyWorld_2)getWorld()).select(this, cd)) {
            isSelected = true;
        }
        adjustAppearance();
    }
    
    /**
     * Unselect a Piece
     */
    public void unselect() {
        isSelected = false;
        adjustAppearance();
    }

    private void adjustAppearance() {
        if (isSelected) getImage().setTransparency(50);
        else getImage().setTransparency(255); 
    }
    
      void checkAppearance() {
        getImage().setTransparency(20); 
    }
    
    /**
     * Return color and direction of the game
     */
    public int cd() {
        return this.cd;
    }

    /**
     * Move the piece
     */
    public void move(Position p) {
        List<Position> L = currStrategy.getLegalPositions();
        ((MyWorld_2)getWorld()).unsetAttackCells(L);
        currStrategy.move(p);
        isSelected = false;
        setLocation(p.getX(),p.getY());
        L = currStrategy.getLegalPositions();
        ((MyWorld_2)getWorld()).setAttackCells(L);
        
    }

    /**
     * Returns a list of all legal positions
     */
    public abstract List<Position> getLegalPositions();

    public boolean isPieceAtOffset(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Piece.class) != null;
    }
    public Actor PieceAtOffset(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Piece.class);
    }

    public boolean isOwnPieceAtOffset(int dx, int dy) {
        return isPieceAtOffset(dx, dy) && cd == ((Piece)getOneObjectAtOffset(dx, dy, Piece.class)).cd();
    }
    
    public boolean isOnBoardDelta(int dx, int dy) {
        return getX()+dx < 8 && getX()+dx >=0 && getY()+dy < 8 && getY()+dy >= 0; 
    }
}
