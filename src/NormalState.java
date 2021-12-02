/**
 * Normal State of the Chess
 * 
 */
public class NormalState implements IBoardState
{
    MyWorld_2 myWorld;
    
    public NormalState(MyWorld_2 mw)
    {
        this.myWorld = mw;
    }

    public void move()
    {
        myWorld.movePiece();
    }
}
