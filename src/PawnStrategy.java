import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
class PawnStrategy extends MoveStrategy
{
    boolean hasYetMoved = false;
    boolean hasMovedTwoSteps = false;
    //boolean hasYetMoved = false;
    Piece P;
    DummyPiece dp;
    PawnStrategy(Piece p){
        P = p;
        dp = new DummyPiece();
    }

    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        if (!hasYetMoved && !P.isPieceAtOffset(0,2*this.P.cd)) {
            list.add(new Position(P.getX(), P.getY() + 2*this.P.cd));
        }
        if(!P.isPieceAtOffset(0,this.P.cd)) list.add(new Position(P.getX(), P.getY()+this.P.cd)); // ceck if there is a piece in front 
        boolean p1present = P.isPieceAtOffset(-1, this.P.cd) && !P.isOwnPieceAtOffset(-1, this.P.cd);
        Piece px_1 =(Piece) P.PieceAtOffset(-1, 0);//  && !P.isOwnPieceAtOffset(-1,0);  
        Piece px1 =(Piece) P.PieceAtOffset(1, 0); //  && !P.isOwnPieceAtOffset(-1,0); 
        boolean temp = (px_1 ==null);
        boolean p2present = P.isPieceAtOffset(1, this.P.cd) && !P.isOwnPieceAtOffset(1, this.P.cd);
        //boolean px1 = P.isPieceAtOffset(1, this.P.cd);
        if ((p1present)) list.add(new Position(P.getX()-1, P.getY()+this.P.cd));
        if ((p2present)) list.add(new Position(P.getX()+1, P.getY()+this.P.cd));
        return list;
    }
    public void move(Position p) {
        /* need to add code for el passant */
        int temp = (P.getY() - p.getY());
        if( temp == 2 || temp == -2){
            hasMovedTwoSteps = true;
        }
        else{
            hasMovedTwoSteps = false;
        }
        hasYetMoved = true;
    }
}
