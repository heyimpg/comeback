package java_gson;


import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class gsonThird {
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

        Gson gson  = new Gson();
        JsonArray jsonArray = gson.toJsonTree(arrList).getAsJsonArray();
        String str = jsonArray.toString();

       /* Gson gson =new Gson();
        String str=  gson.toJson(st1);*/

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(str);
        if(jsonElement.isJsonArray())
        {
            JsonArray jsonArray1 = jsonElement.getAsJsonArray();
            for (int i=0; i<jsonArray1.size();i++)
            {
                JsonObject jsonObject = jsonArray1.get(i).getAsJsonObject();
                Student st = gson.fromJson(jsonObject.toString(), Student.class);
                System.out.println(st.toString());
            }


         /*   System.out.println(jsonObject.get("ID"));
            JsonElement jsonElement1 = jsonObject.get("fullName");
            System.out.println(jsonElement1.getAsString());
            JsonElement jsonElement2 = jsonObject.get("favourite");
            System.out.println(jsonElement2.getAsString());
            System.out.println(jsonObject.get("age"));*/
        }






        System.out.println("\n\n\n--------End Code--------");
    }
}
