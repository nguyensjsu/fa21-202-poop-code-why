/**
 * Write a description of class StateSubject here.
 * 
 * @author (Pratik,Chinmay,Parmeet, Muhammmed Mahmood) 
 * @version (a version number or a date)
 */
public interface IStateSubject  
{
   
/**
     * Add a IStateObserver
     * @param IStateObserver to remove
     */
    void registerObserver( IStateObserver obj ) ;

    /**
     * Remove Observer
     * @param obj  IStateObserver to remove
     */
    void removeObserver( IStateObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;
    
}
