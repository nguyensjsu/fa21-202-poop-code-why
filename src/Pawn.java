import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
/**
 * Pawn.
 * @author Kevin Wehde
 * @version 19.11.2020
 */
public class Pawn extends Piece {

    Pawn(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("pawn-black-50.png");
        else setImage("pawn-white-50.png");
        currStrategy = new PawnStrategy(this);
    }
    Pawn(int cd,World w) {
        super(cd);  
        if (this.cd == 1) setImage("pawn-black-50.png");
        else setImage("pawn-white-50.png");
        currStrategy = new PawnStrategy(this,w);
    }

    public List<Position> getLegalPositions(){
        List<Position> list = currStrategy.getLegalPositions();
/*        if (!hasYetMoved) {
            list.add(new Position(getX(), getY() + 2*this.cd));
        }
        list.add(new Position(getX(), getY() + this.cd));
        Piece p1 = (Piece) getOneObjectAtOffset(-1, this.cd, Piece.class);
        Piece p2 = (Piece) getOneObjectAtOffset(1, this.cd, Piece.class);
        if (p1!=null && p1.cd() == -this.cd) list.add(new Position(p1));
        if (p2!=null && p2.cd() == -this.cd) list.add(new Position(p2));
*/
            
        /*if (!hasYetMoved) {
            list.add(new Position(getX(), getY() + 2*this.cd));
        }
        if(!isPieceAtOffset(0,this.cd)) list.add(new Position(getX(), getY()+this.cd)); // ceck if there is a piece if yes then dont add if no then add  
        Piece p1 = (Piece) getOneObjectAtOffset(-1, this.cd, Piece.class);
        Piece px_1 = (Piece) getOneObjectAtOffset(-1, this.cd, Piece.class);
        Piece p2 = (Piece) getOneObjectAtOffset(1, this.cd, Piece.class);
        Piece px1 = (Piece) getOneObjectAtOffset(1, this.cd, Piece.class);
        if ((p1!=null || px_1!=null) && p1.cd() == -this.cd) list.add(new Position(getX()-1, getY()+this.cd));
        if ((p2!=null || px1!=null ) && p2.cd() == -this.cd) list.add(new Position(getX()+1, getY()+this.cd));
        */
        return list;
    } 
}
