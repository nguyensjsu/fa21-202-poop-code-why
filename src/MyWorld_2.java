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
public class MyWorld_2 extends World implements IElPassantObserver,IElPassantClearSubject {  // PromoteObserver, subject for elpassant

    boolean isPieceSelected;
    Piece selectedPiece = new DummyPiece();
    ArrayList<IMoveStrategy> ElPassantPawns;
    int turn; //1 is Black, -1 is White
    
    //current state
    private IBoardState state;

    //states
    private NormalState normalState;
    private CheckState checkState;
    private CheckmateState checkmateState;

    public MyWorld_2() {    
        super(8, 8, 50);
        ElPassantPawns = new ArrayList<IMoveStrategy>();
        for (int i = 0; i < 8; i++) {
            addObject(new Pawn(1,this), i, 1);
        }
        addObject(new Rook(1), 0, 0);
        addObject(new Rook(1), 7, 0);
        addObject(new Knight(1), 1, 0);
        addObject(new Knight(1), 6, 0);
        addObject(new Bishop(1), 2, 0);
        addObject(new Bishop(1), 5, 0);
        addObject(new Queen(1), 3, 0);
        addObject(new King(1), 4, 0);

        for (int i = 0; i < 8; i++) {
            addObject(new Pawn(-1,this), i, 6);
        }
        addObject(new Rook(-1), 0, 7);
        addObject(new Rook(-1), 7, 7);
        addObject(new Knight(-1), 1, 7);
        addObject(new Knight(-1), 6, 7);
        addObject(new Bishop(-1), 2, 7);
        addObject(new Bishop(-1), 5, 7);
        addObject(new Queen(-1), 3, 7);
        addObject(new King(-1), 4, 7);
        
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
    
    /**
     * Ends the game when checkmate
     * Will implement display on screen later
     */
    public void end(){
        //System.out.println("Game Finished");
    }
}
