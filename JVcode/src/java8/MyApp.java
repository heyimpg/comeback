package java8;

public class MyApp {
    public static void main(String[] args) {
        MyFunction myFunction = MyUtils::add;
        int value = myFunction.accept(3,4);
        System.out.println(value);


        System.out.println("\n\n\n--------End Code--------");
    }
}
