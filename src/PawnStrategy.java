import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
class PawnStrategy extends MoveStrategy implements IElPassantSubject,IElPassantClearObserver 
{
    boolean pelPassant = false;
    boolean nelPassant = false;
    //boolean elPassant = false;
    IElPassantObserver board;
    Piece P;
    DummyPiece dp;
    PawnStrategy(Piece p){
        super();
        P = p;
        dp = new DummyPiece();
    }
    PawnStrategy(Piece p,World w){
        P = p;
        dp = new DummyPiece();
        setWorld(w);
    }
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        if (!hasYetMoved && !P.isPieceAtOffset(0,2*this.P.cd) && !P.isPieceAtOffset(0,this.P.cd)) {
            list.add(new Position(P.getX(), P.getY() + 2*this.P.cd));
        }
        if(!P.isPieceAtOffset(0,this.P.cd)) list.add(new Position(P.getX(), P.getY()+this.P.cd)); // ceck if there is a piece in front 
        boolean p1present = P.isPieceAtOffset(-1, this.P.cd) && !P.isOwnPieceAtOffset(-1, this.P.cd);
        boolean p2present = P.isPieceAtOffset(1, this.P.cd) && !P.isOwnPieceAtOffset(1, this.P.cd);
        if (p1present || nelPassant) list.add(new Position(P.getX()-1, P.getY()+this.P.cd));
        if (p2present || pelPassant) list.add(new Position(P.getX()+1, P.getY()+this.P.cd));
        return list;
    }
    public void move(Position p) {
        /* need to add code for el passant */
        super.move(p);
        int temp = (P.getY() - p.getY());
        if( temp == 2 || temp == -2 /* this.P.cd */){
            Piece p1 = (Piece) P.PieceAtOffset(-1, 2*this.P.cd);
            if (p1 != null && p1.currStrategy.getClass() == PawnStrategy.class){
                PawnStrategy S = (PawnStrategy) p1.currStrategy;
                S.setPElPassant(true);
            }
            Piece p2 = (Piece) P.PieceAtOffset(1, 2*this.P.cd);
            if (p2 != null && p2.currStrategy.getClass() == PawnStrategy.class){
                PawnStrategy S = (PawnStrategy) p2.currStrategy;
                S.setNElPassant(true);
            }
        }
        int dx = p.getX() - P.getX();
        if(dx < 0 && nelPassant){
            notifyBoard(P.PieceAtOffset(-1,0));
        }
        if(dx > 0 && pelPassant){
            notifyBoard(P.PieceAtOffset(1,0));
        }
    }
    public void setNElPassant(boolean value){
        ((IElPassantClearSubject)board).attachPawn(this);
        nelPassant = value; 
    }
    public void setPElPassant(boolean value){
        ((IElPassantClearSubject)board).attachPawn(this);
        pelPassant = value; 
    }
    /* 
     * this function is to notify the board to capture the pawn which was in path of elPassant
     * 
     */
    public void notifyBoard(Actor p){
        board.updateElPassant(p);
    }
    /*
     * attaches the board that we want to notify
     */
    public void attachBoard(World w){
        board = (IElPassantObserver)w;
    }
    /*
     * unsubscribing the board
     */
    public void detachBoard(World w){
        board = null;
    }
    
    public void setWorld(World w){
        board = (IElPassantObserver)w;
    }
    /*
     * this function will be called by the subject i.e. the board when the turn of the player is over to clear all the elpassant pieces
     */
    public void ClearPassants(){
        nelPassant = false;
        pelPassant = false;
    }
}
