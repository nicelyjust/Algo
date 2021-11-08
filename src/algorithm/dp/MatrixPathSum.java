package algorithm.dp;

public class MatrixPathSum {
    public static void main(String[] args) {
        System.out.println(sum(2, 2));
        System.out.println(sum(3, 3));
        System.out.println(sum(21, 21));
    }

    private static int sum(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }
}
