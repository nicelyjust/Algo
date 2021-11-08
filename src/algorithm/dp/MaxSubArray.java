package algorithm.dp;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * 思路: 动态规划
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int size = nums.length;
        int result = nums[0];
        for (int i = 1; i < size; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            result = Math.max(nums[i], result);
        }
        return result;
    }
}
