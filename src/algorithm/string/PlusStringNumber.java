package algorithm.string;

/**
 * https://leetcode-cn.com/problems/add-strings/
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 思路: 倒叙模拟竖式相加流程
 */
public class PlusStringNumber {
    public static void main(String[] args) {
        System.out.println(addStrings("22", "122"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        // 注意 不要忽略最后一位数相加进位的情况
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
