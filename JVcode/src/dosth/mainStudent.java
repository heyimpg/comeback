package dosth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class mainStudent {
    public static void main(String[] args) {
        Student st1 = new Student(1, "Mai Ngọc");
        Student st2 = new Student(3, "Mai Ngọc");
        Student st3 = new Student(2, "Mai Ngọc");
        Student st4 = new Student(4, "Mai Ngọc");

        List<Student> arr = new ArrayList<>();
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        arr.add(st4);

        arr.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getID() - o2.getID());
            }
        });
        for (Student p : arr)
            System.out.println(p.getID()+"-"+p.getName());

        System.out.println("\n\n\n--------End Code--------");
    }
}
