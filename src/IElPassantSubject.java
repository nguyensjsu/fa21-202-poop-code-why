import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class IElPassantSubject here.
 * 
 * @author (chinmay Shukla) 
 * @version (a version number or a date)
 */
public interface IElPassantSubject  
{
    void notifyBoard(Actor p);
    void attachBoard(World w);
    void detachBoard(World w);
}
