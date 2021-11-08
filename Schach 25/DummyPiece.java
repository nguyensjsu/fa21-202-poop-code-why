import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * The purpose of the class DummyPiece is only avoiding using "null" 
 * when no Piece is selected in the class MyWorld. Not terribly useful.
 * @author Kevin Wehde
 * @version25 19.11.2020
 */
public class DummyPiece extends Piece {
    public List<Position> getLegalPositions(){
        return new ArrayList<Position>();
    } 
}
