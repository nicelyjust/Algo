package algorithm.string;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 思路hash表记录,但不能保证顺序;再次迭代原数组
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.containsKey(c));
        }
        for (char c : charArray) {
            if (!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
