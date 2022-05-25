import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double EPS = 0.001;
        double x = 1.25;
        double y = 0;
        double[][] matrix = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        System.out.println("""
                Choose your method
                1.Newton method
                2.Iteration Jacobi method
                """);
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                Newton.SolveSystem(x, y, EPS);
                break;
            case 2:
                Jacobi.Solve(matrix);
                break;
        }
    }
}
