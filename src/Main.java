import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyList<String> colors = new MyList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Orange");
        colors.add("Brown");

        colors.display();

        colors.delete(4);
        colors.display();


    }
}