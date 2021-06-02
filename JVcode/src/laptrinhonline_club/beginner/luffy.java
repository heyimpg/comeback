package laptrinhonline_club.beginner;
import java.util.Scanner;

/***
 * @author PhuongK59-DH-GTVT
 * @since 1/6/2021
 * Ý tưởng: Tính toán ra điểm trung gian -> khoảng cách tới tất cả các điểm sẽ là ngắn nhất
 */

public class luffy {
    public static  float Point(int Arr[])
    {
        int point = 0;
        for (int i : Arr) {
            point +=  i;
        }
        return  (float) point/Arr.length;
    }
    public static  float Far(float point , int Arr[])
    {
        float sum = 0;
        for (int i : Arr) {
            sum+= Math.abs(point - i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*  Enter Input*/
        System.out.println("Input: ");
        //N
        System.out.print("N= ");
        int N = scanner.nextInt();
        if (N<1 || N>500 )
        {
            System.out.println("Fail");
            return;
        }
        //Arr
        System.out.println("Enter value Arr:");
        int[] Arr = new int[N];
        for (int i = 0; i <N ; i++) {
            System.out.print("Arr["+i+"] = ");
            Arr[i] = scanner.nextInt();
            if (Arr[i]<1 || Arr[i]>3000)
            {
                System.out.println("Fail");
                return;
            }
        }
/*Procedure exam*/
        float point = Point(Arr);
/*Return Output*/
        System.out.println("Output = " + Far(point, Arr));
        System.out.println("\n\n\n--------End Code--------");
    }
}
