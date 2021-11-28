import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

class BishopStrategy extends MoveStrategy
{
    // instance variables - replace the example below with your own
    Piece P;
    BishopStrategy(Piece p){
        P = p;
    }

    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        int d = 1;      
        while (P.getX() + d < 8 && P.getY() + d < 8 && !P.isOwnPieceAtOffset(d, d)) {
            list.add(new Position(P.getX()+d, P.getY()+d));
            if (P.isPieceAtOffset(d, d)) break;
            d++;
        }
        d = 1;
        while (P.getX() - d >= 0 && P.getY() + d < 8 && !P.isOwnPieceAtOffset(-d, d)) {
            list.add(new Position(P.getX()-d, P.getY()+d));
            if (P.isPieceAtOffset(-d, d)) break;
            d++;     
        }
        d = 1;
        while (P.getX() + d < 8 && P.getY() - d >= 0 && !P.isOwnPieceAtOffset(d, -d)) {
            list.add(new Position(P.getX()+d, P.getY()-d));
            if (P.isPieceAtOffset(d, -d)) break;
            d++;
        }
        d = 1;
        while (P.getX() - d >= 0 && P.getY() - d >= 0 && !P.isOwnPieceAtOffset(-d, -d)) {
            list.add(new Position(P.getX()-d, P.getY()-d));
            if (P.isPieceAtOffset(-d,-d)) break;
            d++;
        }
        return list;
    }
}