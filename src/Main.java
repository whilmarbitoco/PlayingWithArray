//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyNode<String> test = new MyNode<>();

        test.add("Cat");
        test.add("Dog");
        test.add("Zebra");
        test.add("Lion");
        test.add("Parrot");
        test.add("Penguin");

        test.display();
        System.out.println("++++++++++++++++++++++++++++++++=");
//        test.delete(0);
        test.delete("Cat");
        test.delete("Lion");
        test.display();
    }
}