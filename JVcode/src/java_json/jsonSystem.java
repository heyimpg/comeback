package java_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class jsonSystem {
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

        JSONArray jsonArray = new JSONArray();

        arrList.forEach((item) ->{
            //C1
              /*  JSONObject jsonObject =new JSONObject();
                jsonObject.put("ID", item.getID());
                jsonObject.put("fullName", item.getFullName());
                jsonObject.put("favourite", item.getFavourite());
                jsonObject.put("age", item.getAge());*/
            jsonArray.put(item);
        });

        System.out.println("Size = " + jsonArray.length());

        for (int i = 0 ; i<jsonArray.length(); i++)
        {
            try {
//                C1
              /*  JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int ID = jsonObject1.getInt("ID");
                String fullName = jsonObject1.getString("fullName");
                String favourite = jsonObject1.getString("favourite");
                int age = jsonObject1.getInt("age");
                Student st = new Student(ID, fullName, favourite, age);
                System.out.println(st.toString());*/

                Student st = (Student) jsonArray.get(i);
                System.out.println(st.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        System.out.println("\n\n\n--------End Code--------");
    }
}
