import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
/**
 * Queen.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class Queen extends Piece {
    Queen(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("queen-black-50.png");
        else setImage("queen-white-50.png");
    }
     
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        int d = 1;      
        while (getX() + d < 8 && getY() + d < 8 && !isOwnPieceAtOffset(d, d)) {
            list.add(new Position(getX()+d, getY()+d));
            if (isPieceAtOffset(d, d)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && getY() + d < 8 && !isOwnPieceAtOffset(-d, d)) {
            list.add(new Position(getX()-d, getY()+d));
            if (isPieceAtOffset(-d, d)) break;
            d++;     
        }
        d = 1;
        while (getX() + d < 8 && getY() - d >= 0 && !isOwnPieceAtOffset(d, -d)) {
            list.add(new Position(getX()+d, getY()-d));
            if (isPieceAtOffset(d, -d)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && getY() - d >= 0 && !isOwnPieceAtOffset(-d, -d)) {
            list.add(new Position(getX()-d, getY()-d));
            if (isPieceAtOffset(-d,-d)) break;
            d++;
        }
        d = 1;
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
        }
        return list;
    } 
}
