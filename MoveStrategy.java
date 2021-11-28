import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class MoveStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MoveStrategy implements IMoveStrategy 
{
    public abstract List<Position> getLegalPositions();

    public void move(Position p) {
    }
    public void setNeighborsElPassant(){
    }
}
