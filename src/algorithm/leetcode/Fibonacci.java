package algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/
 *
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int fib1(int n) {
        final int MOD = 1000000007;
        if (n == 0 || n == 1)
            return n;
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
