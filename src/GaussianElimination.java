public class GaussianElimination {
    public static final boolean debug = false;

    public static void main(String[] args) throws Exception {
        double[][] normalMatrix = new double[][]{
                {2,1,1,5},
                {4,-6,0,-2},
                {-2,7,2,9}};
        double[][] singularMatrix = new double[][]{
                {1,1,1},
                {2,2,5},
                {4,4,8}
        };
        double[][] rowExchangeMatrix = new double[][]{
                {1,1,1},
                {2,2,5},
                {4,6,8}
        };
        double[][] matrix = normalMatrix;
        gaussianEliminate(matrix);
        IO.printMatrix(matrix);
    }

    public static void gaussianEliminate(double[][] matrix) throws Exception {
        gaussianEliminate(matrix, 0);
    }

    public static void gaussianEliminate(double[][] matrix, int subMatrixIndex) throws Exception {
        if (subMatrixIndex >= matrix.length) {
            return;
        }
        for (int i = subMatrixIndex + 1; i < matrix.length; i++) {
            double pivot = matrix[subMatrixIndex][subMatrixIndex];
            if (pivot == 0) {
                pivot = handleZeroPivot(matrix, subMatrixIndex);
            }
            double ratio = matrix[i][subMatrixIndex] / pivot;
            for (int j = subMatrixIndex; j < matrix[0].length; j++) {
                matrix[i][j] -= matrix[subMatrixIndex][j] * ratio;
            }
        }
        if (debug) {
            IO.printMatrix(matrix);
            System.out.println();
        }
        gaussianEliminate(matrix, subMatrixIndex + 1);
    }

    private static double handleZeroPivot(double[][] matrix, int pivotIndex) throws Exception {
        for (int i = pivotIndex; i < matrix.length; i++) {
            if (matrix[i][pivotIndex] != 0) {
                double[] temp = matrix[i];
                matrix[i] = matrix[pivotIndex];
                matrix[pivotIndex] = temp;
                return matrix[pivotIndex][pivotIndex];
            }
        }
        throw new Exception("matrix cannot be gaussian eliminated: singular form");
    }
}
