import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

class RookStrategy extends MoveStrategy{
    Piece P;
    RookStrategy(Piece p){
        super();
        P = p;
    }    
    public List<Position> getLegalPositions(){
    List<Position> list = new ArrayList<Position>();
            int d = 1;
            while (P.getX() + d < 8 && !P.isOwnPieceAtOffset(d, 0)) {
                    list.add(new Position(P.getX()+d, P.getY()));
                    if (P.isPieceAtOffset(d, 0)) break;
                    d++;
            }
            d = 1;
            while (P.getX() - d >= 0 && !P.isOwnPieceAtOffset(-d, 0)) {
                    list.add(new Position(P.getX()-d, P.getY()));
                    if (P.isPieceAtOffset(-d, 0)) break;
                    d++;
            }
            d = 1;
            while (P.getY() + d < 8 && !P.isOwnPieceAtOffset(0, d)) {
                list.add(new Position(P.getX(), P.getY()+d));
                if (P.isPieceAtOffset(0, d)) break;
                d++;
            }
            d = 1;
            while (P.getY() - d >= 0 && !P.isOwnPieceAtOffset(0, -d)) {
                list.add(new Position(P.getX(), P.getY()-d));
                if (P.isPieceAtOffset(0,-d)) break;
                d++;
            }
            return list;
    }
    public void move(Position p) {
        super.move(p);
    }
}