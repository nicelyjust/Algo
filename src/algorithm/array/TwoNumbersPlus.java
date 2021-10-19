package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/ 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 方法1:暴力枚举,寻找target-value的值
 * 方法2:
 */
public class TwoNumbersPlus {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 1, 7};
        int[] result = twoNumbersPlus(nums, 8);
        int[] result1 = twoNumbersPlus2(nums, 8);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }

    private static int[] twoNumbersPlus(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }

    private static int[] twoNumbersPlus2(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}

