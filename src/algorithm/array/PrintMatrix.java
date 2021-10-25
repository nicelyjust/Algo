package algorithm.array;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 顺时针打印矩阵
 */
public class PrintMatrix {

    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int[] result = new int[width * height];
        int index = 0;
        int top = 0, left = 0;
        int right = width - 1;
        int bottom = height - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (left > --right) break;

            for (int i = right; i >= left; i--) {
                result[index++] = matrix[bottom][i];
            }
            if (top > --bottom) break;

            for (int i = bottom; i >= top; i--) {
                result[index++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return result;
    }
}
