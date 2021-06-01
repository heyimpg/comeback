package exercise_json;

import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class b1_gson {
    public static void main(String[] args) {
        String link = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(link);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String value = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((value = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(value);
            }

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(stringBuilder.toString());
            if(jsonElement.isJsonArray())
            {
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                System.out.println("Total Post : " + jsonArray.size());
                System.out.println("List Post:");
                for (int i = 0; i < jsonArray.size(); i++) {
                    System.out.println("---------------(POST "+(i+1)+")---------------------");
                    JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                    Post pt = gson.fromJson(jsonObject.toString(), Post.class);
                    System.out.println(pt.toString());
                }
            }
            else
            {
                System.out.println("error 404 !");
            }

            /*JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            System.out.println("Total Post : " + jsonArray.length());
            System.out.println("List Post:");
            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println("---------------(POST "+(i+1)+")---------------------");
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int userId = jsonObject.getInt("userId");
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String body = jsonObject.getString("body");

                Post pt = new Post(userId, id, title, body);
                System.out.println(pt.toString());
            }*/



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n--------End Code--------");
    }
}
