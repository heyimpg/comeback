package java_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonTes {
    public static void main(String[] args) throws JSONException {
        Student st1 = new Student(1, "An", "Cat",17);
        Student st2 = new Student(2, "ba", "Cat",17);
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID",st1.getID());
        jsonObject.put("fullName",st1.getFullName());
        jsonObject.put("favourite",st1.getFavourite());
        jsonObject.put("age",st1.getAge());

        System.out.println(jsonObject.toString());*/

        /*JSONArray jsonArray = new JSONArray();
        jsonArray.put(st1);
        jsonArray.put(st2);
        System.out.println(jsonArray.toString());
        System.out.println("Size = " + jsonArray.length());*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", st1);
        
        Student st = (Student) jsonObject.get("a");
        System.out.println(st.toString());

        System.out.println("\n\n\n--------End Code--------");
    }
}
