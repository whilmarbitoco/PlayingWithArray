//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyList<String> test = new MyList<>();

        test.add("Cat");
        test.add("Dog");
        test.add("Zebra");
        test.add("Lion");
        test.add("Parrot");
        test.add("Penguin");

        test.display();

       test.add("Horse", 1);
        test.display();
//        System.out.println(test);
    }
}