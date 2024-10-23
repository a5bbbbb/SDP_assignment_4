package observer;

import java.util.Scanner;

public class NewsChannel implements ObserverInterface{
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String headline) {
        System.out.println(name + " received a headline: " + headline);
    }
}
