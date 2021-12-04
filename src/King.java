import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * King.
 * @author Kevin Wehde
 * @version 19.11.2020
 */
public class King extends Piece
{
    King(int cd) {
        super(cd);  
        if (cd == 1) setImage("king-black-50.png");
        else setImage("king-white-50.png");
        currStrategy = new KingStrategy(this);
    }
   
    public List<Position> getLegalPositions(){
        List<Position> list = currStrategy.getLegalPositions();
        /*if (!isOwnPieceAtOffset(1, 0) && isOnBoardDelta(1, 0)) {
            list.add(new Position(getX()+1, getY()));
        }
        if (!isOwnPieceAtOffset(-1, 0) && isOnBoardDelta(-1, 0)) {
            list.add(new Position(getX()-1, getY()));
        }
        if (!isOwnPieceAtOffset(0, 1) && isOnBoardDelta(0, 1)) {
            list.add(new Position(getX(), getY()+1));
        }
        if (!isOwnPieceAtOffset(0, -1) && isOnBoardDelta(0, -1)) {
            list.add(new Position(getX(), getY()-1));
        }
        if (!isOwnPieceAtOffset(1, 1) && isOnBoardDelta(1, 1)) {
            list.add(new Position(getX()+1, getY()+1));
        }
        if (!isOwnPieceAtOffset(-1, 1) && isOnBoardDelta(-1, 1)) {
            list.add(new Position(getX()-1, getY()+1));
        }
        if (!isOwnPieceAtOffset(1, -1) && isOnBoardDelta(1, -1)) {
            list.add(new Position(getX()+1, getY()-1));
        }
        if (!isOwnPieceAtOffset(-1, -1) && isOnBoardDelta(-1, -1)) {
            list.add(new Position(getX()-1, getY()-1));
        }*/
        return list;
    } 
     public void checkAppearance() {
        super.checkAppearance();
    }
}
