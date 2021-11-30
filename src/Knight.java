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
        currStrategy = new KnightStrategy(this);
    }
  
    public List<Position> getLegalPositions(){
        List<Position> list = currStrategy.getLegalPositions();
        /*if (!P.isOwnPieceAtOffset(1,2) && P.isOnBoardDelta(1,2)) {
            list.add(new Position(P.getX()+1, P.getY()+2)); 
        }
        if (!P.isOwnPieceAtOffset(1,-2) && P.isOnBoardDelta(1,-2)) {
            list.add(new Position(P.getX()+1, P.getY()-2)); 
        }
        if (!P.isOwnPieceAtOffset(-1,2) && P.isOnBoardDelta(-1,2)) {
            list.add(new P.Position(P.getX()-1, P.getY()+2)); 
        }
        if (!P.isOwnPieceAtOffset(-1,-2) && P.isOnBoardDelta(-1,-2)) {
            list.add(new Position(P.getX()-1, P.getY()-2)); 
        }
        if (!P.isOwnPieceAtOffset(-2,1) && P.isOnBoardDelta(-2,1)) {
            list.add(new Position(P.getX()-2, P.getY()+1)); 
        }
        if (!P.isOwnPieceAtOffset(-2,-1) && P.isOnBoardDelta(-2,-1)) {
            list.add(new Position(P.getX()-2, P.getY()-1)); 
        }
        if (!P.isOwnPieceAtOffset(2,1) && P.isOnBoardDelta(2,1)) {
            list.add(new Position(P.getX()+2, P.getY()+1)); 
        }
        if (!P.isOwnPieceAtOffset(2,-1) && P.isOnBoardDelta(2,-1)) {
            list.add(new Position(P.getX()+2, P.getY()-1)); 
        }*/
        return list;
    } 
}
