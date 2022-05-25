public class Operations {
    static public void printMatrix(double[][] matrix) {
        for (double[] rows : matrix) {
            for (double column : rows) {
                System.out.printf("%8.3f", column);
            }
            System.out.println();
        }
    }

    static public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        double[][] res = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return res;
    }

    static public double t(double[][] matrix){
        double res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j){
                    res += matrix[i][j]*matrix[i][j];
                }
            }
        }
        return res;
    }
}
