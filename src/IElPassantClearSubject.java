import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class IElPassantClearSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IElPassantClearSubject  
{
    void notifyPawns();
    void attachPawn(IMoveStrategy P);
    void detachPawns();
}
