import greenfoot.World;

/**
 * Write a description of class RegularFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegularFactory extends IFactory 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RegularFactory
     */
    public RegularFactory()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void buildBoard(World world)
    {
        world.addObject(new Rook(1), 0, 0);
        world.addObject(new Rook(1), 7, 0);
        world.addObject(new Knight(1), 1, 0);
        world.addObject(new Knight(1), 6, 0);
        world.addObject(new Bishop(1), 2, 0);
        world.addObject(new Bishop(1), 5, 0);
        world.addObject(new Queen(1), 3, 0);
        world.addObject(new King(1), 4, 0);

        for (int i = 0; i < 8; i++) {
            world.addObject(new Pawn(-1,world), i, 6);
        }
        world.addObject(new Rook(-1), 0, 7);
        world.addObject(new Rook(-1), 7, 7);
        world.addObject(new Knight(-1), 1, 7);
        world.addObject(new Knight(-1), 6, 7);
        world.addObject(new Bishop(-1), 2, 7);
        world.addObject(new Bishop(-1), 5, 7);
        world.addObject(new Queen(-1), 3, 7);
        world.addObject(new King(-1), 4, 7);
    }
}
