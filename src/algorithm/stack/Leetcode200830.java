package algorithm.stack;

import java.util.Stack;

/**
 * @Desc https://leetcode-cn.com/problems/valid-parentheses/;
 * @Author lizeng
 * @CreateTime 2020/8/30 19:20
 * 思路:用栈辅助解法
 **/
public class Leetcode200830 {
    public static void main(String[] args) {
        System.out.println(isValid("[]{]}"));

    }

    private static boolean isValid(String source) {
        if (source.isEmpty()) {
            return true;
        }
        char[] chars = source.toCharArray();
        if ((chars.length & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
