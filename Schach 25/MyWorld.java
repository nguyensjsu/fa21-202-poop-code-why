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
public class MyWorld extends World {

    boolean isPieceSelected;
    Piece selectedPiece = new DummyPiece();
    int turn; //1 is Black, -1 is White

    public MyWorld() {    
        super(8, 8, 50); 
        for (int i = 0; i < 8; i++) {
            addObject(new Pawn(1), i, 1);
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
            addObject(new Pawn(-1), i, 6);
        }
        addObject(new Rook(-1), 0, 7);
        addObject(new Rook(-1), 7, 7);
        addObject(new Knight(-1), 1, 7);
        addObject(new Knight(-1), 6, 7);
        addObject(new Bishop(-1), 2, 7);
        addObject(new Bishop(-1), 5, 7);
        addObject(new Queen(-1), 3, 7);
        addObject(new King(-1), 4, 7);

        isPieceSelected = false;
        selectedPiece = new DummyPiece();
        turn = 1; //Black starts
        prepare();
    }

    public void act() {
        movePiece();
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

    private void movePiece() {
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
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
