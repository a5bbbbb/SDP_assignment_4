package observer;

import java.util.LinkedList;
import java.util.List;

public class NewsAgency implements ObservableInterface{
    private String latestHeadline;
    private List<ObserverInterface> observers;

    public NewsAgency(String latestHeadline) {
        this.latestHeadline = latestHeadline;
        observers = new LinkedList<>();
    }

    @Override
    public void add(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void remove(ObserverInterface observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ObserverInterface observer : observers){
            observer.update(latestHeadline);
        }
    }

    public void publishHeadline(String headline){
        this.latestHeadline = headline;
    }
}
