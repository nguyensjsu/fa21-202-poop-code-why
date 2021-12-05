/**
 * Write a description of class ICheckSubject here.
 * @author (Pratik,Chinmay,Parmeet, Muhammmed Mahmood)  
 * @version (a version number or a date)
 */
public interface ICheckSubject  
{
    

   /**
     * Add a StateObserver
     * @param obj to remove
     */
    void registerCheckObserver( ICheckObserver obj ) ;

    /**
     * Remove Observer
     * @param obj  IStateObserver to remove
     */
    void removeCheckObserver( ICheckObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyCheckObserver();
}
