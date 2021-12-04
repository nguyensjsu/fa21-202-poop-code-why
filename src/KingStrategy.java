import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
class KingStrategy extends MoveStrategy 
{
    Piece P;
    World board;
    KingStrategy(Piece p){
        super();
        P = p;
    }
    KingStrategy(Piece p,World w){
        P = p;
        board = w;
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
        if(!hasYetMoved){
            boolean RightCastlePossible=isRightCastlePossible();
            if(RightCastlePossible){
                list.add(new Position(P.getX()+2, P.getY()));
            }
            boolean LeftCastlePossible=isLeftCastlePossible();
            if(LeftCastlePossible){
                list.add(new Position(P.getX()-2, P.getY()));
            }
        }
        List<Position> underAttack = new ArrayList<Position>();
        // find all cells under attack and remove them from the list
        for(Position p : list){
            if(((MyWorld_2)board).isUnderAttack(p)){
                underAttack.add(p);
            }
        }
        list.removeAll(underAttack);
        return list;
    } 
    public boolean isRightCastlePossible(){
        // check for pieces between the rook and the king
        boolean clearPath = !P.isPieceAtOffset(+1,0) && !P.isPieceAtOffset(+2,0);
        Actor p = P.PieceAtOffset(3,0);
        boolean RookObeys = p != null && !(( Piece )p).currStrategy.hasYetMoved();
        boolean NoCellsUnderattack = !((MyWorld_2)board).isUnderAttack(P.getX()+1,P.getY()) && 
        !((MyWorld_2)board).isUnderAttack(P.getX()+2,P.getY());
        return clearPath && NoCellsUnderattack && RookObeys;
    }
    public boolean isLeftCastlePossible(){
        // check for pieces between the rook and the king
        boolean clearPath = !P.isPieceAtOffset(-1,0) && !P.isPieceAtOffset(-2,0) && !P.isPieceAtOffset(-3,0);
        Actor p = P.PieceAtOffset(-4,0);
        boolean RookObeys = p != null && !(( Piece )p).currStrategy.hasYetMoved();
        boolean NoCellsUnderattack = !((MyWorld_2)board).isUnderAttack(new Position(P.getX()-1,P.getY())) && 
        !((MyWorld_2)board).isUnderAttack(new Position(P.getX()-2,P.getY())) && 
        !((MyWorld_2)board).isUnderAttack(new Position(P.getX()-3,P.getY())); 
        return clearPath && NoCellsUnderattack && RookObeys;
    }
    public void move(Position p) {
        /* notify board of castle*/
        super.move(p);
        if(p.getX() - P.getX() == -2){
            ((MyWorld_2)board).notifyLeftCastle();
        }
        else if(p.getX() - P.getX() == 2){
            ((MyWorld_2)board).notifyRightCastle();
        }

        
    }
}
