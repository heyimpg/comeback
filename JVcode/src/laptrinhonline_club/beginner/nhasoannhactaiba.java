package laptrinhonline_club.beginner;

/***
 * @author PhuongK59-DH-GTVT
 * @since 1/6/2021
 * Ý tưởng: So sánh gtri của 3 số cuối với GTTB của dãy
 */

public class nhasoannhactaiba {
    public static void main(String[] args) {
        //Input
        int[] Arr = {8,7,6,5,4,3,2,1};
        int N = Arr.length;
        float TB = 0;
        //Pro
        for (int i = 0; i < Arr.length; i++) {
            TB += (float) Arr[i]/N;
        }

        float end = (float) (Arr[N-1] + Arr[N-2] + Arr[N-3])/3;

        float check = end - TB ;
        //Output
        if (check>-1 && check<1)
            System.out.println("KHONGBIET");
        else if(check<-1)
            System.out.println("GIAM");
        else
            System.out.println("TANG");

        System.out.println("\n\n\n--------End Code--------");
    }
}
