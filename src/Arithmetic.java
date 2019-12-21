import java.util.Arrays;

public class Arithmetic {
    public static double[][] plus(double[][] m1, double[][] m2) throws Exception {
        if (!(m1.length == m2.length && m1[0].length == m2[0].length)) {
            throw new Exception("Matrix addition error: matrices inconsistency.");
        }
        double[][] matrix = new double[m1.length][m1[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return matrix;
    }

    public static double[][] minus(double[][] m1, double[][] m2) throws Exception {
        return plus(m1, times(m2, -1));
    }

    public static double[][] times(double[][] matrix, double c) {
        double[][] newMatrix = matrix.clone();
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0 ; j < newMatrix[0].length; j++) {
                newMatrix[i][j] *= c;
            }
        }
        return newMatrix;
    }

    public static double[][] times(double c, double[][] matrix) {
        return times(matrix, c);
    }

    public static double[][] times(double[][] m1, double[][] m2) throws Exception {
        if (!(m1.length == m2[0].length && m1[0].length == m2.length)) {
            throw new Exception("Matrix multiplying error: matrices inconsistency.");
        }
        double[][] matrix = new double[m1.length][m2[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] =rowInnerProductCol(m1, m2, i, j);
            }
        }
        return matrix;
    }

    private static double rowInnerProductCol(double[][] m1, double[][] m2, int rowIndex, int colIndex) {
        double sum = 0;
        for (int i = 0; i < m2.length; i++) {
            sum += m1[rowIndex][i] * m2[i][colIndex];
        }
        return sum;
    }
}
