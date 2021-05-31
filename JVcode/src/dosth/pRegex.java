package dosth;

import java.util.regex.Pattern;

public class pRegex {
    public static void main(String[] args) {
        String regex = "@";

        //String text2 = "2/12/2018";
        String str  = "ok@gmail.com";
        Pattern pattern = Pattern.compile(regex);

        System.out.println(pattern.matcher(str).matches());


        System.out.println("\n\n\n--------End Code--------");
    }
}
