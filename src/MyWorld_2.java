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
public class MyWorld_2 extends World implements IElPassantObserver,IElPassantClearSubject,IStateSubject,ICheckSubject{  // PromoteObserver, subject for elpassant

    boolean isPieceSelected;
    Piece selectedPiece = new DummyPiece();
    ArrayList<IMoveStrategy> ElPassantPawns;
    int turn; //1 is Black, -1 is White
    ArrayList<Piece> BlackPieces;
    ArrayList<Piece> WhitePieces;
    King BlackKing = new King(1);
    King WhiteKing =  new King(-1);
    
    private IStateObserver checkMateObserver;
    private ICheckObserver checkObserver;

    //current state
    private IBoardState state;
    
    //states
    private NormalState normalState;
    private IFactory ChessFactory;
    private WhiteCheckmateState whiteCMState;
    private BlackCheckmateState blackCMState;

    public MyWorld_2() {    
        super(8, 8, 50);
        ElPassantPawns = new ArrayList<IMoveStrategy>();

        ChessFactory = new RegularFactory();
        ChessFactory.buildBoard(this);
        
        normalState = new NormalState(this);
        blackCMState = new BlackCheckmateState(this);
        whiteCMState = new WhiteCheckmateState(this);

        //register checkMateObserver
        this.registerCheckMateObserver(new checkMateObserver(this));
        this.registerCheckObserver(new checkObserver(this));
 
        
        state = normalState; // Starts with Normal State

        isPieceSelected = false;
        selectedPiece = new DummyPiece();
        turn = -1; //White starts
    }

    /**
     * Method for Greenfoot to execute on repeat
     * until Greenfoot.stop()
     */
    public void act() {
        //movePiece();
        stateMethod();// Using this instead to initiate the current state's appropriate method
    }
    
    /**
     * Uses the state's move method
     */
    public void stateMethod(){
         if(state == whiteCMState || state == blackCMState)
        {
            state.endGame();
        }
        else if(state == normalState)
        {
            state.move();
            state.endGame();
    
        }
       
    }
    
    /**
     * Change state of the board
     * 
     * @param state, change to this state
     */
    public void changeState(IBoardState state){
        this.state= state;
    }

    /**
     * Selects the piece that cursor selects
     * 
     * @param p , piece to be moved
     * @param cd
     */
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

    /**
     * Shows the legal moves for the selected piece
     */
    private void showLegalMoves() {
        List<Position> legalPositions = selectedPiece.getLegalPositions();
        for (Position p: legalPositions) {
            addObject(new HighlightPosition(), p.getX(), p.getY());
        }
    }

    /**
     * Moves the pieces in the world
     * If king is captured, the game ends
     */
    public void movePiece() {
        //WhiteKing.setImage("king-white-50.png");
        //BlackKing.setImage("king-black-50.png");
        for (HighlightPosition p: getObjects(HighlightPosition.class)) {
            Boolean KingCaptureFlag = true;
            if (Greenfoot.mouseClicked(p)) {
                Position targetPosition = new Position(p);
                List<Piece> l = getObjectsAt(targetPosition.getX(), targetPosition.getY(), Piece.class);
                selectedPiece.move(targetPosition);
                
                if (l.size() > 0) {
                    
                 capture(l.get(0));
                 if(l.get(0).currStrategy.getClass() == KingStrategy.class){
                    this.notifyCheckMateObserver();
                    KingCaptureFlag =false;
                    }
                   
                }
                
                unselectPiece(selectedPiece);
                
                changeTurn();
                if (KingCaptureFlag)
                      // notify checkobserver of moving pieces
                     this.notifyCheckObserver();
                else
                    continue;
                
          
            }
        }
    }
    
    /**
     * Change turn of the game
     */
    private void changeTurn() {
        notifyPawns();
        turn = -turn;
    }
    
    /**
     * Capture the piece
     * 
     * @param p piece to capture
     */
    private void capture(Piece p) {
        //System.out.println(l.get(0).getClass());
        // Checks if the piece captures is a king and notifycheckmate observer
        
        removeObject(p);
        
        
       
    }
    
    /**
     * Unselect a piece
     * 
     * @param p piece to unselect
     */
    private void unselectPiece(Piece p) {
        p.unselect();
        selectedPiece = new DummyPiece();
        isPieceSelected = false;
        clearHighlights();
    }

    /**
     * Clears the yellow highlighted path
     */
    private void clearHighlights() {
        removeObjects(getObjects(HighlightPosition.class));
    }
    
    public void updateElPassant(Actor p){ /*this is to capture the pawn in alpassant path*/
        removeObject(p);
    }
    
    /**
     * Notify the pawns
     */
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
    
    /**
     * Attach the pawns
     */
    public void attachPawn(IMoveStrategy P){
        ElPassantPawns.add(P);
    }
    
    /**
     * Detach the pawns
     */
    public void detachPawns(){
        ElPassantPawns.clear();
    }
    
    
    public void registerCheckMateObserver(IStateObserver obj){
        this.checkMateObserver = obj;
    }
    
    public void removeCheckMateObserver(IStateObserver obj){
        this.checkMateObserver = null;
    }
    
    public void notifyCheckMateObserver(){
         if ( this.checkMateObserver != null )
            this.checkMateObserver.checkmateEvent();
    };
    
     
    public void registerCheckObserver( ICheckObserver obj ){
        this.checkObserver = obj;
    } ;
    
    public void removeCheckObserver( ICheckObserver obj ){
        this.checkObserver = null;
    } ;
    
     public void notifyCheckObserver( ){
         if ( this.checkObserver != null )
         {
            Boolean flag = verifyCheck();
            //System.out.print(flag);
            if (flag ){
                this.checkObserver.checkEvent();
            }
            
        }
    } ;
    
    
    public Boolean verifyCheck(){
        getAllActor()  ; 
        
        for( King k :  getObjects(King.class)){
            if (k.cd == 1)
            BlackKing = k;
            else if  (k.cd == -1)
            WhiteKing = k;
        }
        List<Position> list = new ArrayList<Position>();
        if (turn == -1 )
        {
            //its white's turn check all the black pieces
            for (Piece p : BlackPieces){
                //get all the legal positions of black pieces
                list.addAll(p.getLegalPositions());
                
            }
            for (Position p : list){
                if (p.getX()==WhiteKing.getX() && p.getY()==WhiteKing.getY()){
                    WhiteKing.setImage("WhiteCheck.jpg");
                return true;
            }
            }
        }
        else if (turn == 1 )
        {
             //its black's turn check all the white pieces
             for (Piece p : WhitePieces){
                 //get all the legal positions of  white pieces
                 list.addAll(p.getLegalPositions());
            }
            for (Position p : list){
                if (p.getX()==BlackKing.getX() && p.getY()==BlackKing.getY()){
                BlackKing.setImage("checkBlack.jpeg");
                    return true;
                }
            }
            
        }
        return false;
    }
    
    public void getAllActor(){
        WhitePieces = new ArrayList<Piece>();
        BlackPieces = new ArrayList<Piece>();
        for ( Piece p :  getObjects(Piece.class)){
         if (p.cd == 1)
            BlackPieces.add(p);
         else
             WhitePieces.add(p);
    }
}
    /*
    public void end()
    {
        //String whoWon; 
        
        if(state== whiteCMState)
            Greenfoot.setWorld(new WhiteWonWorld());
        else if(state == blackCMState)
            Greenfoot.setWorld(new BlackWonWorld());
        //showText("Black Won!",4,3);
        
        //Greenfoot.stop();
    }
    */
}