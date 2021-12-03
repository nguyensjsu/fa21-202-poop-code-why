public class CheckMachine implements CheckSubject {
    private CheckObserver observers;


    @Override
    public void registerObserver(CheckObserver obj) {
    this.observers = obj;
    }

    /**
     * Remove Observer
     *
     * @param obj
     */
    @Override
    public void removeObserver(CheckObserver obj) {
        this.observers = null;
    }

    /**
     * Broadcast Event to Observers
     */
    @Override
    public void notifyObserver() {
        if (this.observers != null) {
            this.observers.checkUpdate();
        }
    }
}
