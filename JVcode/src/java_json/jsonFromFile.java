package java_json;

import java.io.*;

public class jsonFromFile {
    public static void main(String[] args) {
            String path = "src/java_json/data.json";
        File file  =new File(path);
       FileReader fr = null;
       BufferedReader br =null;
        try {
            fr = new FileReader(file);
            br =new BufferedReader(fr);
            String value = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((value=br.readLine()) != null)
            {
                System.out.println(value);
                stringBuilder.append(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n--------End Code--------");
    }
}
