package algorithm.array;

import algorithm.utils.CommonUtil;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * <p>
 * 审题:
 */
public class FindRepeatInArray {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        // easy solution
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], i);
        }

        return -1;

    }

    public int findRepeatNumber1(int[] nums) {
        int length = nums.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            ints[num] += 1;
            if (ints[num] > 1) {
                return num;
            }
        }
        return -1;
    }
    /**
     * 原地交换,有重复值,说明索引与值是一对多的关系,
     *
     */
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        int length = nums.length;
        while (i < length){
            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]){
                return nums[i];
            }
            CommonUtil.swap(nums, i, nums[i]);
        }
        return -1;
    }
}
