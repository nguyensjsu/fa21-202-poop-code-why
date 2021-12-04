import greenfoot.World;
import java.util.*;


/**
 * Write a description of class RandomFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomFactory extends IFactory 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RandomFactory
     */
    public RandomFactory()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void buildBoard(World world)
    {
        ArrayList<Piece> whitePieces= new ArrayList<Piece>();        
        ArrayList<Piece> blackPieces= new ArrayList<Piece>();
        
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(-1));
            blackPieces.add(new Pawn(1));
        }
        
        whitePieces.add(new Rook(-1));
        whitePieces.add(new Rook(-1));
        whitePieces.add(new Knight(-1));
        whitePieces.add(new Knight(-1));
        whitePieces.add(new Bishop(-1));
        whitePieces.add(new Bishop(-1));
        whitePieces.add(new Queen(-1));
        
        blackPieces.add(new Rook(1));
        blackPieces.add(new Rook(1));
        blackPieces.add(new Knight(1));
        blackPieces.add(new Knight(1));
        blackPieces.add(new Bishop(1));
        blackPieces.add(new Bishop(1));
        blackPieces.add(new Queen(1));
   
   
               
        
        world.addObject(whitePieces.get(8), 0, 7);
        world.addObject(whitePieces.get(9), 7, 7);
        world.addObject(whitePieces.get(10), 1, 7);
        world.addObject(whitePieces.get(11), 6, 7);
        world.addObject(whitePieces.get(12), 2, 7);
        world.addObject(whitePieces.get(13), 5, 7);
        world.addObject(whitePieces.get(14), 3, 7);
        world.addObject(new King(-1), 4, 7);

        for (int i = 0; i < 8; i++) {
            world.addObject(whitePieces.get(i), i, 6);
            world.addObject(blackPieces.get(i), i, 1);

        }
        world.addObject(blackPieces.get(8), 0, 0);
        world.addObject(blackPieces.get(9), 7, 0);
        world.addObject(blackPieces.get(10), 1,0);
        world.addObject(blackPieces.get(11), 6, 0);
        world.addObject(blackPieces.get(12), 2, 0);
        world.addObject(blackPieces.get(13), 5, 0);
        world.addObject(blackPieces.get(14), 3, 0);
        world.addObject(new King(1), 4,0);
        
        Collections.shuffle(whitePieces);
        Collections.shuffle(blackPieces);
        
        whitePieces.get(0).setCurrStrategy(new RookStrategy(whitePieces.get(0)));
        whitePieces.get(1).setCurrStrategy(new RookStrategy(whitePieces.get(1)));
        whitePieces.get(2).setCurrStrategy(new KnightStrategy(whitePieces.get(2)));
        whitePieces.get(3).setCurrStrategy(new KnightStrategy(whitePieces.get(3)));
        whitePieces.get(4).setCurrStrategy(new BishopStrategy(whitePieces.get(4)));
        whitePieces.get(5).setCurrStrategy(new BishopStrategy(whitePieces.get(5)));
        whitePieces.get(6).setCurrStrategy(new QueenStrategy(whitePieces.get(6)));
        
        blackPieces.get(0).setCurrStrategy(new RookStrategy(blackPieces.get(0)));
        blackPieces.get(1).setCurrStrategy(new RookStrategy(blackPieces.get(1)));
        blackPieces.get(2).setCurrStrategy(new KnightStrategy(blackPieces.get(2)));
        blackPieces.get(3).setCurrStrategy(new KnightStrategy(blackPieces.get(3)));
        blackPieces.get(4).setCurrStrategy(new BishopStrategy(blackPieces.get(4)));
        blackPieces.get(5).setCurrStrategy(new BishopStrategy(blackPieces.get(5)));
        blackPieces.get(6).setCurrStrategy(new QueenStrategy(blackPieces.get(6)));

        for(int i=7;i<14;i++) {
            whitePieces.get(i).setCurrStrategy(new PawnStrategy(whitePieces.get(i)));
            blackPieces.get(i).setCurrStrategy(new PawnStrategy(blackPieces.get(i)));
        }
        
    }
}
