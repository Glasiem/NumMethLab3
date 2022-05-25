import static java.lang.Math.*;

public class Jacobi {

    static final void printMatrix(double[][] m) {
        for (double[] doubles : m) {
            for (double aDouble : doubles) {
                System.out.printf("%8.3f", aDouble);
            }
            System.out.println();
        }
    }

    static public void Solve(double[][] matrix){
        double max = matrix[1][2];
        int ipos = 1;
        int jpos = 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j){
                    if (matrix[i][j] > max){
                        max = matrix[i][j];
                        ipos = i;
                        jpos = j;
                    }
                }
            }
        }
        double fi = atan(2*matrix[ipos][jpos]/(matrix[jpos][jpos]-matrix[ipos][ipos]))/2.0;
        double[][] u = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[0].length; j++) {
                if(i == j){
                    u[i][j] = 1;
                }
                else{
                    u[i][j] = 0;
                }
            }
        }
        u[ipos][ipos] = cos(fi);
        u[jpos][jpos] = cos(fi);
        u[jpos][ipos] = sin(fi);
        u[ipos][jpos] = -sin(fi);
        double[][] ut = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < ut.length; i++) {
            for (int j = 0; j < ut[0].length; j++) {
                ut[i][j] = u[j][i];
            }
        }
        double[][] matrix1 = Operations.multiply(u,Operations.multiply(matrix,ut));
        System.out.println("A1:");
        Operations.printMatrix(matrix1);
        System.out.println("t(A): " + Operations.t(matrix));
        System.out.println("t(A1): " + Operations.t(matrix1));
    }
}
