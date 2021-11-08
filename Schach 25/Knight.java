import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Knight.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class Knight extends Piece
{
    Knight(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("knight-black-50.png");
        else setImage("knight-white-50.png");
    }
  
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        if (!isOwnPieceAtOffset(1,2) && isOnBoardDelta(1,2)) {
            list.add(new Position(getX()+1, getY()+2)); 
        }
        if (!isOwnPieceAtOffset(1,-2) && isOnBoardDelta(1,-2)) {
            list.add(new Position(getX()+1, getY()-2)); 
        }
        if (!isOwnPieceAtOffset(-1,2) && isOnBoardDelta(-1,2)) {
            list.add(new Position(getX()-1, getY()+2)); 
        }
        if (!isOwnPieceAtOffset(-1,-2) && isOnBoardDelta(-1,-2)) {
            list.add(new Position(getX()-1, getY()-2)); 
        }
        if (!isOwnPieceAtOffset(-2,1) && isOnBoardDelta(-2,1)) {
            list.add(new Position(getX()-2, getY()+1)); 
        }
        if (!isOwnPieceAtOffset(-2,-1) && isOnBoardDelta(-2,-1)) {
            list.add(new Position(getX()-2, getY()-1)); 
        }
        if (!isOwnPieceAtOffset(2,1) && isOnBoardDelta(2,1)) {
            list.add(new Position(getX()+2, getY()+1)); 
        }
        if (!isOwnPieceAtOffset(2,-1) && isOnBoardDelta(2,-1)) {
            list.add(new Position(getX()+2, getY()-1)); 
        }
        return list;
    } 
}
