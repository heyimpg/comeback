package java_json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class jsonOnline {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String value = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((value = bufferedReader.readLine()) != null)
            {
                System.out.println(value);
                stringBuilder.append(value);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            System.out.println("------------------------------------");

            System.out.println(jsonObject.getString("monhoc"));
            System.out.println(jsonObject.getString("noihoc"));
            System.out.println(jsonObject.getString("website"));
            System.out.println(jsonObject.getString("fanpage"));
            System.out.println(jsonObject.getString("logo"));

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
