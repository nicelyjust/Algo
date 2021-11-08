package algorithm.dp;

/**
 * 解题思路:动态规划,找到状态转移方程
 * algorithm.dp[i][j] = Math.min(algorithm.dp[i][j-1],algorithm.dp[i-1][j]) + grid[][]
 */
public class MinPathSum {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/0i0mDW/
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] result = new int[row][column];
        // 先将两条边的dp[row][0]及dp[0][column]
        result[0][0] = grid[0][0];
        for (int i = 1; i < column; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                result[i][j] = Math.min(result[i][j - 1], result[i - 1][j]) + grid[i][j];
            }
        }
        return result[row - 1][column - 1];
    }
}
