package java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class mainPerson {
    public static void main(String[] args) {
        Person p1 = new Person(1, "IP4", 500);
        Person p2 = new Person(2, "IP5", 700);
        Person p3 = new Person(3, "IP6", 200);
        Person p4 = new Person(4, "IP7", 1000);
        Person  p5 = new Person(5, "IP8", 1500);

        List<Person> arrLis = new ArrayList<>();
        arrLis.add(p5);
        arrLis.add(p4);
        arrLis.add(p3);
        arrLis.add(p2);
        arrLis.add(p1);

        System.out.println("Ds origin: ");
        arrLis.forEach(System.out::println);

        System.out.println("Ds filter: ");
        Stream<Person> stream = arrLis.stream().filter(p->p.getPrice()>700);
        stream.forEach((p)->{
            System.out.println(p.toString());
        });



        System.out.println("\n\n\n--------End Code--------");
    }
}
