package laptrinhonline_club.beginner;
/***
 * @author PhuongK59-DH-GTVT
 * @since 1/6/2021
 * Ý tưởng: Chạy vòng lặp i, j ,k cho x,y,z tăng dần và so sánh
 */
public class bo3songuyen {
    public static void main(String[] args) {
        int N = 2, S =2;
        if(N<2 || N>2500 || S<0 || S>3*N)
            return;
        int x = 0, y=0, z= 0;
      //  int loop = (int) Math.pow(3, (N+1)); : total loop
        for (int i = 0; i <= S; i++) {
            x= i;
            if(x+y+z == S)
                System.out.println(x+"-"+y+"-"+z);
            else
            {
                for (int j = 0; j <= S; j++) {
                    y= j;
                    if(x+y+z == S)
                        System.out.println(x+"-"+y+"-"+z);
                    else
                        for (int k = 0; k <= S; k++) {
                            z= k;
                            if(x+y+z == S)
                                System.out.println(x+"-"+y+"-"+z);
                        }
                }
            }
        }

        System.out.println("\n\n\n--------End Code--------");
    }
}
