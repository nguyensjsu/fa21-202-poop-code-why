import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Rook.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class Rook extends Piece
{
    IMoveStrategy currStrategy;
    Rook(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("rook-black-50.png");
        else setImage("rook-white-50.png");
        currStrategy = new RookStrategy(this);
    }

    public List<Position> getLegalPositions(){
        List<Position> list = currStrategy.getLegalPositions();// new ArrayList<Position>();
        /*int d = 1;
        while (getX() + d < 8 && !isOwnPieceAtOffset(d, 0)) {
            list.add(new Position(getX()+d, getY()));
            if (isPieceAtOffset(d, 0)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && !isOwnPieceAtOffset(-d, 0)) {
            list.add(new Position(getX()-d, getY()));
            if (isPieceAtOffset(-d, 0)) break;
            d++;
        }
        d = 1;
        while (getY() + d < 8 && !isOwnPieceAtOffset(0, d)) {
            list.add(new Position(getX(), getY()+d));
            if (isPieceAtOffset(0, d)) break;
            d++;
        }
        d = 1;
        while (getY() - d >= 0 && !isOwnPieceAtOffset(0, -d)) {
            list.add(new Position(getX(), getY()-d));
            if (isPieceAtOffset(0,-d)) break;
            d++;
        }*/
        return list;
    } 
}
