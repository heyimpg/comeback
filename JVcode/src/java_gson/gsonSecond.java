package java_gson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class gsonSecond {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        System.out.println(jsonString);
        Gson gson = new Gson();
        Person  person = gson.fromJson(jsonString, Person.class);
        System.out.println(person.toString());


        System.out.println("\n\n\n--------End Code--------");
    }
}
