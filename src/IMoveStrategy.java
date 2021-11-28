import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class MoveStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IMoveStrategy
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    List<Position> getLegalPositions();
    void move(Position p);
}
