//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyMap<String, Integer> maps = new MyMap<>();

        maps.put("FB", 20);
        maps.put("Ea", 30);

        System.out.println(maps.containsValue(20));
//        maps.display();




    }
}