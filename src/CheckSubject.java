public interface CheckSubject {
    void registerObserver( CheckObserver obj ) ;

    /**
     * Remove Observer
     * @param obj Pin AUth Observer to Remove
     */
    void removeObserver(   CheckObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;
}
