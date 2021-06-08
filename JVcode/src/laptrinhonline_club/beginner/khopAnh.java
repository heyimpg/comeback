package laptrinhonline_club.beginner;
/***
 * @author PhuongK59-DH-GTVT
 * @since 1/6/2021
 * Ý tưởng: chạy vòng lặp lấy ra 1 matrix con size bằng matrix B từ A rồi so sánh với matrix B
 * Result: FAIL
 */
public class khopAnh {
    public static boolean checkMatrix(int[][] matrix,int[][] matrix2 )
    {
        for (int i = 0; i < matrix.length-1; i++) {
            int valueI = i;
            for (int j = 0; j < matrix[0].length-1 ; j++) {
                int valueJ = j;
                for (int k = 0; k <matrix2.length ; k++) {
                    for (int l = 0; l < matrix2[0].length ; l++) {
                        if(matrix[valueI][valueJ] != matrix2[k][l])
                            return false;
                        valueJ++;

                    }
                    valueI++;
                    valueJ = j;
                }
                valueI = i;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4},{5,6}};
        int[][] matrix2= {{1,2},{3,4}};


        if (checkMatrix(matrix, matrix2))
            System.out.println("Similar");
        else
            System.out.println("Different");
        
        System.out.println("\n\n\n--------End Code--------");
    }
}
