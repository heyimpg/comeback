package exercise_json;

import java_json.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class b1 {
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

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
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
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n--------End Code--------");
    }
}
