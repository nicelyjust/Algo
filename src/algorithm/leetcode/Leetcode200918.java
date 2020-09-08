package algorithm.leetcode;

public class Leetcode200918 {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     *
     * @param x 是否是回文数,从左往右读跟从右往左读结果一样
     * @return
     */
    private static boolean isPalindrome(int x) {
        // 排除负数,变为字符串,然后将其反转
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        /*String src = String.valueOf(x);
        char[] srcChar = src.toCharArray();
        int size = srcChar.length - 1;
        int length = srcChar.length / 2;
        for (int i = 0; i < length; i++) {
            char temp = srcChar[i];
            srcChar[i] = srcChar[size - i];
            srcChar[size - i] = temp;
        }
        return String.valueOf(srcChar).equals(src);*/

        //解法二: 排除负数,判断多少位数,然后对折比较数值
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;

    }
}
