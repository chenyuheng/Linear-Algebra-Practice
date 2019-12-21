public class Const {
    public static double[][] getIdenticalMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    public static double[][] getElementaryMatrix(int size, int subtractRowIndex, int subtractedRowIndex, double multiplier) {
        double[][] matrix = getIdenticalMatrix(size);
        matrix[subtractedRowIndex][subtractRowIndex] = -multiplier;
        return matrix;
    }

    public static double[][] getInverseElementaryMatrix(int size, int subtractRowIndex, int subtractedRowIndex, double multiplier) {
        return getElementaryMatrix(size, subtractRowIndex, subtractedRowIndex, -multiplier);
    }

    public static double[][] getPermutationMatrix(int size, int rowIndex1, int rowIndex2) {
        double[][] matrix = getIdenticalMatrix(size);
        double[] temp = matrix[rowIndex1];
        matrix[rowIndex1] = matrix[rowIndex2];
        matrix[rowIndex2] = temp;
        return matrix;
    }
}
