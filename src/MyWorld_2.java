import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

/**
 * Chess board to play with two players, no AI implemented.
 * There is no keeping track of the score or detection
 * of check mate or even of capturing the king.
 * Black and White are encoded as 1 (Black) and -1 (White).
 * This encoding is used to determine the direction of movement
 * of the Pawn, the image for the Pieces and the player's turn.
 * @author Kevin Wehde 
 * @version25 19.11.2020
 */
public class MyWorld_2 extends World implements IElPassantObserver,IElPassantClearSubject,ICastlingObserver {  // PromoteObserver, subject for elpassant

    boolean isPieceSelected;
    Piece selectedPiece = new DummyPiece();
    ArrayList<IMoveStrategy> ElPassantPawns;
    boolean[][][] AttackMatrix;
    int turn; //1 is Black, -1 is White
    
    //current state
    private IBoardState state;

    //states
    private NormalState normalState;
    private CheckState checkState;
    private CheckmateState checkmateState;
    private IFactory ChessFactory;

    public MyWorld_2() {    
        super(8, 8, 50);
        AttackMatrix = new boolean[8][8][3];       
        ElPassantPawns = new ArrayList<IMoveStrategy>();

        ChessFactory = new RandomFactory();
        //ChessFactory = new RegularFactory();
        ChessFactory.buildBoard(this);
        
        normalState = new NormalState(this);
        checkState = new CheckState(this);
        checkmateState = new CheckmateState(this);
        
        state = normalState; // Starts with Normal State

        isPieceSelected = false;
        selectedPiece = new DummyPiece();
        turn = -1; //White starts
    }

    public void act() {
        //movePiece();
        
        move(); // Using this instead to initiate the current state's appropriate method
    }

    public boolean select(Piece p, int cd) {
        if (cd == turn) {
            if (isPieceSelected) {
                unselectPiece(selectedPiece);
            }
            isPieceSelected = true;
            selectedPiece = p;
            showLegalMoves();
            return true; 
        } else {
            return false;
        }
    }

    private void showLegalMoves() {
        List<Position> legalPositions = selectedPiece.getLegalPositions();
        for (Position p: legalPositions) {
            addObject(new HighlightPosition(), p.getX(), p.getY());
        }
    }
    
    /**
     * Uses the state's move method
     * If normal state, uses MovePiece()
     * If check state, uses.....
     * If checkmate state, uses ..... 
     */
    public void move(){
        state.move();
    }
    
    /**
     * Change state
     * 
     * @param state, change to this state
     */
    public void changeState(IBoardState state){
        this.state= state;
    }

    public void movePiece() {
        for (HighlightPosition p: getObjects(HighlightPosition.class)) {
            if (Greenfoot.mouseClicked(p)) {
                Position targetPosition = new Position(p);
                List<Piece> l = getObjectsAt(targetPosition.getX(), targetPosition.getY(), Piece.class);
                selectedPiece.move(targetPosition);
                if (l.size() > 0) capture(l.get(0));
                unselectPiece(selectedPiece);
                changeTurn();
            }
        }
    }
    
    private void changeTurn() {
        notifyPawns();
        turn = -turn;
    }
    
    private void capture(Piece p) {
        List<Position> L = p.currStrategy.getLegalPositions();
        unsetAttackCells(L,-turn);
        removeObject(p);
    }
    
    private void unselectPiece(Piece p) {
        p.unselect();
        selectedPiece = new DummyPiece();
        isPieceSelected = false;
        clearHighlights();
    }

    private void clearHighlights() {
        removeObjects(getObjects(HighlightPosition.class));
    }
    public void updateElPassant(Actor p){ /*this is to capture the pawn in alpassant path*/
        removeObject(p);
    }
    public void notifyPawns(){
        boolean detach = false;
        for(IMoveStrategy p : ElPassantPawns){
            if(((PawnStrategy)p).P.cd() == turn){
                ((IElPassantClearObserver)p).ClearPassants();
                detach = true;
            }
        }
        if(detach){
             detachPawns();
            }
    }
    public void attachPawn(IMoveStrategy P){
        ElPassantPawns.add(P);
    }
    public void detachPawns(){
        ElPassantPawns.clear();
    }
    public void setAttackCells(List<Position> L){
        for(Position p:L){
            AttackMatrix[p.getX()][p.getY()][1+turn]=true;
        }
    }
    public void unsetAttackCells(List<Position> L){
        for(Position p:L){
            AttackMatrix[p.getX()][p.getY()][1+turn] = false;
        }
    }
    public void setAttackCells(List<Position> L,int myturn){
        for(Position p:L){
            AttackMatrix[p.getX()][p.getY()][1+myturn]=true;
        }
    }
    public void unsetAttackCells(List<Position> L,int myturn){
        for(Position p:L){
            AttackMatrix[p.getX()][p.getY()][1+myturn] = false;
        }
    }
    public boolean isUnderAttack(Position p){
        return AttackMatrix[p.getX()][p.getY()][1-turn];
    }
    public boolean isUnderAttack(int x, int y){
        return AttackMatrix[x][y][1-turn];
    }
    public void notifyRightCastle(){
        int y;
        if(turn == 1){
            //black is notifying for castle
            y = 0;
        }
        else{
            y = 7;
        }
        List<Piece> Alist = getObjectsAt(7,y,Piece.class);
        Alist.get(0).move(new Position(5,y));
    }
    public void notifyLeftCastle(){
        int y;
        if(turn == 1){
            //black is notifying for castle
            y = 0;
        }
        else{
            y = 7;
        }        
        List<Piece> Alist = getObjectsAt(0,y,Piece.class);
        Alist.get(0).move(new Position(3,y));
    }
}
