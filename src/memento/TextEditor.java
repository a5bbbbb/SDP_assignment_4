package memento;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class TextEditor implements TextEditorInterface{
    private String currentText;

    private Stack<Memento> history;

    private final class Memento{
        private final String text;

        private Memento(String text) {
            this.text = text;
        }

        private String getText(){
            return text;
        }
    }

    public TextEditor() {
        currentText = "";
        history = new Stack<>();
        history.push(new Memento(""));
    }

    @Override
    public void run(Scanner scan) {
        System.out.println(
            "Choose one operation:\n" +
            "1. View text\n" +
            "2. Add Text (to exit enter !q as last characters and hit enter)\n" +
            "3. Save current state\n" +
            "4. restore last saved state\n" +
            "5. exit Text Editor"
        );
        int op = scan.nextInt();
        switch (op) {
            case 1:
                System.out.println("=============\n" + getCurrentText() + "\n==============\n");
                break;
            case 2:
                addText(scan);
                break;
            case 3:
                saveState();
                break;
            case 4:
                restoreLastState();
                break;
            case 5:
                return;
            default:
                System.out.println("Unknown operation. Please try again: ");
        }
        run(scan);
    }

    public String getCurrentText() {
        return currentText;
    }

    private void setCurrentText(String currentText) {
        this.currentText = currentText;
    }

    private void addText(Scanner scan){
        String line;
        while(true){
            line = scan.nextLine();
            if(line.contains("!q")){
                line = line.substring(0, line.indexOf("!q"));
                addLine(line);
                break;
            }
            addLine(line);
        }
    }

    private void addLine(String line){
        if(Objects.equals(line, ""))return;

        if(Objects.equals(getCurrentText(), "")) {
            setCurrentText(line);
            return;
        }
        setCurrentText(getCurrentText() + '\n' + line);
    }

    private void saveState(){
        Memento currentState = new Memento(currentText);
        history.push(currentState);
    }

    private void restoreLastState(){
        if(history.isEmpty())return;
        setCurrentText(history.pop().getText());
    }
}
