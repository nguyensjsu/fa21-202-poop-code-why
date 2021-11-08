import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Bishop.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class Bishop extends Piece {
    
    Bishop(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("bishop-black-50.png");
        else setImage("bishop-white-50.png");
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
        return list;
    } 
    
   
}
