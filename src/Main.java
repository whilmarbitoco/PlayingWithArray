//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    MyNode<String> nodes = new MyNode<>();

        for (int i = 0; i < 15; i++) {
            nodes.add(Integer.toString(i));
        }

        nodes.recursiveDisplay();



    }
}