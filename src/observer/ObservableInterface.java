package observer;

public interface ObservableInterface {
    void add(ObserverInterface observer);
    void remove(ObserverInterface observer);
    void notifyObservers();
}
