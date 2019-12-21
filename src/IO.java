import java.math.BigDecimal;

public class IO {
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(new BigDecimal(String.valueOf(matrix[i][j])).stripTrailingZeros().toPlainString() + " ");
            }
            System.out.println();
        }
    }
}
