package algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * <p>
 * 思路: 排序找中间数;摩尔投票法假设一个众数 X,如若相等 votes +1,否则 -1,votes == 0时赋值为下一个假设众数
 */
public class FindMajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public static int majorityElement1(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
