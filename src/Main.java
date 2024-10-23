import interpreter.Context;
import interpreter.ContextInterface;
import interpreter.Interpreter;
import interpreter.InterpreterInterface;
import memento.TextEditor;
import memento.TextEditorInterface;
import observer.NewsAgency;
import observer.NewsChannel;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1(){
        System.out.println("Please enter expression using numbers, +, - only: ");
        String expr = scan.nextLine();
        ContextInterface context = new Context();
        InterpreterInterface interpreter = new Interpreter(context);
        try {
            int res = interpreter.interpret(expr);
            System.out.println("The result is: " + res);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private static void task2(){
        TextEditorInterface textEditor = new TextEditor();
        textEditor.run(scan);
    }

    private static void task3(){
        NewsAgency agency = new NewsAgency("Amazing headline.");
        NewsChannel channel1 = new NewsChannel("ABC news");
        NewsChannel channel2 = new NewsChannel("BBC news");
        NewsChannel channel3 = new NewsChannel("CNN news");
        agency.add(channel1);
        agency.add(channel2);
        agency.add(channel3);
        agency.notifyObservers();
        agency.publishHeadline("Incredible headline.");
        agency.remove(channel2);
        agency.notifyObservers();
    }
}
