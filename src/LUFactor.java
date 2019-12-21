public class LUFactor {
    public static final boolean debug = false;

    public static void main(String[] args) throws Exception {
        double[][] matrix = new double[][]{
                {2,1,1},
                {4,-6,0},
                {-2,7,2}};
        double[][][] lu = factor(matrix);
        IO.printMatrix(lu[0]);
        IO.printMatrix(lu[1]);
        IO.printMatrix(Arithmetic.times(lu[1], lu[0]));
    }

    public static double[][][] factor(double[][] matrix) throws Exception {
        return factor(matrix, 0);
    }

    public static double[][][] factor(double[][] matrix, int subMatrixIndex) throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("Matrix error: only square matrices are supported for LU factor.");
        }
        if (subMatrixIndex == matrix.length) {
            return new double[][][]{matrix, Const.getIdenticalMatrix(matrix.length)};
        }
        double pivot = matrix[subMatrixIndex][subMatrixIndex];
        double[] multipliers = new double[matrix.length - subMatrixIndex - 1];
        for (int i = subMatrixIndex + 1; i < matrix.length; i++) {
            multipliers[i - subMatrixIndex - 1] = matrix[i][subMatrixIndex] / pivot;
        }
        for (int i = 0; i < multipliers.length; i++) {
            matrix = Arithmetic.times(Const.getElementaryMatrix(matrix.length, subMatrixIndex, subMatrixIndex + i + 1, multipliers[i]), matrix);
        }
        double[][] lower = Const.getIdenticalMatrix(matrix.length);
        for (int i = multipliers.length - 1; i >= 0; i--) {
            lower = Arithmetic.times(lower, Const.getInverseElementaryMatrix(matrix.length, subMatrixIndex, subMatrixIndex + i + 1, multipliers[i]));
        }
        double[][][] LU = factor(matrix, subMatrixIndex + 1);
        lower = Arithmetic.times(lower, LU[1]);
        if (debug) {
            System.out.println("subMatrixIndex: " + subMatrixIndex);
            System.out.println("Upper:");
            IO.printMatrix(matrix);
            System.out.println("Lower:");
            IO.printMatrix(lower);
            System.out.println("--------------");
        }
        return new double[][][]{LU[0], lower};
    }
}
