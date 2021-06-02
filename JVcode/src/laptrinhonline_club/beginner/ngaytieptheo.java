package laptrinhonline_club.beginner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 * @author PhuongK59-DH-GTVT
 * @since 1/6/2021
 * Ý tưởng: Sử dụng lớp simpledateFormat để chuyển input từ định dạng String -> Date -> calendar .(xử lý).. ->outPut
 */

public class ngaytieptheo {
    public static void main(String[] args) throws Exception {
        //Input
        String input = "30/4/1975";
        System.out.println("Input = "+ input);
        //Procedure
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Date date = formatter.parse(input);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,1);
        //Output
            String output = formatter.format(calendar.getTime());
            System.out.println("Ouput = "+output);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("\n\n\n--------End Code--------");
    }
}
