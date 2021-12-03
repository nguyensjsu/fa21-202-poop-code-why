import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;


/**
 * Write a description of class BlackWonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackWonWorld  extends World
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BlackWonWorld
     */
    public BlackWonWorld()
    {
        super(5, 3, 50);
    }

    public void act(){
        showText("Black Won!",2,1);
        Greenfoot.stop();
    }
}
