import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public class KnightStrategy extends MoveStrategy
{
    
    // instance variables - replace the example below with your own
    Piece P;
    KnightStrategy(Piece p){
        super();
        P = p;
    }

    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        if (!P.isOwnPieceAtOffset(1,2) && P.isOnBoardDelta(1,2)) {
            list.add(new Position(P.getX()+1, P.getY()+2)); 
        }
        if (!P.isOwnPieceAtOffset(1,-2) && P.isOnBoardDelta(1,-2)) {
            list.add(new Position(P.getX()+1, P.getY()-2)); 
        }
        if (!P.isOwnPieceAtOffset(-1,2) && P.isOnBoardDelta(-1,2)) {
            list.add(new Position(P.getX()-1, P.getY()+2)); 
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
        }
        return list;
    } 
}
