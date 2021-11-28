import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
class KingStrategy extends MoveStrategy 
{
   Piece P;
    KingStrategy(Piece p){
        P = p;
    }

    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        if (!P.isOwnPieceAtOffset(1, 0) && P.isOnBoardDelta(1, 0)) {
            list.add(new Position(P.getX()+1, P.getY()));
        }
        if (!P.isOwnPieceAtOffset(-1, 0) && P.isOnBoardDelta(-1, 0)) {
            list.add(new Position(P.getX()-1, P.getY()));
        }
        if (!P.isOwnPieceAtOffset(0, 1) && P.isOnBoardDelta(0, 1)) {
            list.add(new Position(P.getX(), P.getY()+1));
        }
        if (!P.isOwnPieceAtOffset(0, -1) && P.isOnBoardDelta(0, -1)) {
            list.add(new Position(P.getX(), P.getY()-1));
        }
        if (!P.isOwnPieceAtOffset(1, 1) && P.isOnBoardDelta(1, 1)) {
            list.add(new Position(P.getX()+1, P.getY()+1));
        }
        if (!P.isOwnPieceAtOffset(-1, 1) && P.isOnBoardDelta(-1, 1)) {
            list.add(new Position(P.getX()-1, P.getY()+1));
        }
        if (!P.isOwnPieceAtOffset(1, -1) && P.isOnBoardDelta(1, -1)) {
            list.add(new Position(P.getX()+1, P.getY()-1));
        }
        if (!P.isOwnPieceAtOffset(-1, -1) && P.isOnBoardDelta(-1, -1)) {
            list.add(new Position(P.getX()-1, P.getY()-1));
        }
        return list;
    } 

}
