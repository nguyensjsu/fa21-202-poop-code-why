public interface CheckSubject {
    void registerObserver( CheckObserver obj ) ;

    /**
     * Remove Observer
     * @param obj
     */
    void removeObserver(   CheckObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;
}
