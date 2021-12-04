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
    protected boolean hasYetMoved = false;
    List<Position> attackCells;
    protected MoveStrategy(){
        attackCells = new ArrayList<Position>();
    }
    public abstract List<Position> getLegalPositions();

    public void move(Position p) {
        hasYetMoved = true;
        return;
    }
    public List<Position> getAttackCells() {
        return attackCells;
    }
    public void setAttackCells(List<Position> L) {
        attackCells.clear();
        for(Position p : L){
            attackCells.add(p);
        }
    }
    public boolean hasYetMoved(){
        return hasYetMoved;
    }
}
