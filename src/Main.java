//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyNode<String> animals = new MyNode<>();

        animals.add("Alligator");
        animals.add("Bull");
        animals.add("Chicken");
        animals.add("Dinosaur");
        animals.add("Eagle");
        animals.add("Fish");
        animals.add("Goat");

        animals.display();
        animals.delete("Fish");
        animals.delete("Fish");
        animals.display();
    }
}