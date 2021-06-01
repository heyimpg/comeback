package java_gson;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class gsonFirst {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student st1 = new Student(1, "An", "Cat",17);
        Student st2 = new Student(2, "Ba", "Dog",18);
        Student st3 = new Student(3, "Minh", "Lion",15);
        Student st4 = new Student(4, "Bo", "Giraffe",21);
        Student st5 = new Student(5, "Me", "Penguin",27);
        Student st11 = (Student) st1.clone();
        Student st21 = (Student) st2.clone();
        Student st31 = (Student) st3.clone();
        Student st41 = (Student) st4.clone();
        Student st51 = (Student) st5.clone();

        List<Student> arrList = new ArrayList<>();
        arrList.add(st5);
        arrList.add(st4);
        arrList.add(st3);
        arrList.add(st2);
        arrList.add(st1);
        arrList.add(st11);
        arrList.add(st21);
        arrList.add(st31);
        arrList.add(st41);
        arrList.add(st51);

        Gson gson = new Gson();
        String[] str = new String[arrList.size()];
        for (int i = 0; i < arrList.size() ; i++) {
            str[i] = gson.toJson(arrList.get(i));
        }

        for (int i = 0; i < arrList.size() ; i++) {
            Student st = gson.fromJson(str[i], Student.class);
            System.out.println(st.toString());
        }




        System.out.println("\n\n\n--------End Code--------");
    }
}
